package com.campusai.service;

import com.campusai.model.ChatResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    public ChatResponse answer(String question, String studentId) {
        String q = question == null ? "" : question.toLowerCase();

        String answer;
        String source;

        if (containsAny(q, "attendance", "absent", "percentage")) {
            answer = "Students should maintain the minimum attendance percentage required by the college regulations. For an exact percentage and condonation rules, check the official Attendance Regulations document.";
            source = "Attendance Regulations.pdf";
        } else if (containsAny(q, "exam", "examination", "semester exam")) {
            answer = "Examination dates, registration deadlines and hall-ticket information are published in the official academic calendar and examination notices.";
            source = "Academic Calendar.pdf";
        } else if (containsAny(q, "leave", "permission")) {
            answer = "For leave, submit the required leave request to the appropriate department authority and follow the college approval procedure.";
            source = "Student Regulations.pdf";
        } else if (containsAny(q, "syllabus", "subject", "subjects", "course")) {
            answer = "You can ask for a semester or subject-specific syllabus. Example: 'What subjects are in 7th semester?'";
            source = "University Syllabus.pdf";
        } else if (containsAny(q, "notice", "circular", "announcement")) {
            answer = "The latest college notices are available in the Notices section. You can also ask me about exam, placement or academic announcements.";
            source = "College Notices";
        } else if (containsAny(q, "placement", "job", "interview")) {
            answer = "Placement announcements normally include eligibility, registration deadline, company details and interview schedule. Check the latest placement notice before registering.";
            source = "Placement Cell Notices";
        } else if (containsAny(q, "hello", "hi", "hey")) {
            answer = "Hello! 👋 I am CampusAI. I can help with attendance, exams, syllabus, leave, notices and placement-related college questions.";
            source = "CampusAI";
        } else {
            answer = "I could not find a reliable answer in the current college knowledge base. Try asking about attendance, exams, syllabus, leave, notices or placements.";
            source = "CampusAI Knowledge Base";
        }

        return new ChatResponse(
            answer,
            source,
            List.of("What is the attendance requirement?",
                    "When are the semester exams?",
                    "Show latest notices")
        );
    }

    private boolean containsAny(String text, String... words) {
        for (String word : words) {
            if (text.contains(word)) return true;
        }
        return false;
    }
}

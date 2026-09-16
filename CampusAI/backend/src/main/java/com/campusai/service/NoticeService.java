package com.campusai.service;

import com.campusai.model.Notice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    public List<Notice> getNotices() {
        return List.of(
            new Notice(1L, "Semester Examination Registration", "2026-09-08",
                    "Examination", "Students are requested to complete examination registration before the deadline announced by the examination cell."),
            new Notice(2L, "Placement Drive Registration", "2026-09-06",
                    "Placement", "Eligible final and pre-final year students can register through the placement cell."),
            new Notice(3L, "Academic Calendar Update", "2026-09-04",
                    "Academic", "Students should follow the latest academic calendar for internal assessments and semester activities.")
        );
    }
}

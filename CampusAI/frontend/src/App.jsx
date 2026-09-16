import { useEffect, useState } from 'react'

const API = 'http://localhost:8080/api'

function App() {
  const [messages, setMessages] = useState([])
  const [question, setQuestion] = useState('')
  const [notices, setNotices] = useState([])
  const [loading, setLoading] = useState(false)
  const [activePage, setActivePage] = useState('chat')

  useEffect(() => {
    fetch(`${API}/notices`)
      .then(res => res.json())
      .then(setNotices)
      .catch(() => setNotices([]))
  }, [])

  const sendMessage = async (text = question) => {
    if (!text.trim() || loading) return

    const userText = text.trim()
    setMessages(prev => [...prev, { role: 'user', text: userText }])
    setQuestion('')
    setLoading(true)

    try {
      const res = await fetch(`${API}/chat`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ question: userText, studentId: 'student001' })
      })

      if (!res.ok) throw new Error('Request failed')
      const data = await res.json()

      setMessages(prev => [...prev, {
        role: 'bot',
        text: data.answer,
        source: data.source,
        suggestions: data.suggestions || []
      }])
    } catch {
      setMessages(prev => [...prev, {
        role: 'bot',
        text: 'Cannot connect to the Spring Boot backend. Make sure the backend is running on port 8080.'
      }])
    } finally {
      setLoading(false)
    }
  }

  const clearChat = () => setMessages([])

  return (
    <div className="app">
      <aside className="sidebar">
        <div className="brand">
          <div className="logo">🎓</div>
          <div>
            <h2>CampusAI</h2>
            <span>Student Support</span>
          </div>
        </div>

        <button className={activePage === 'chat' ? 'nav active' : 'nav'} onClick={() => setActivePage('chat')}>
          💬 Ask CampusAI
        </button>
        <button className={activePage === 'notices' ? 'nav active' : 'nav'} onClick={() => setActivePage('notices')}>
          📢 Notices
        </button>

        <div className="sidebar-bottom">
          <div className="student-card">
            <div className="avatar">S</div>
            <div>
              <strong>Student</strong>
              <small>student001</small>
            </div>
          </div>
        </div>
      </aside>

      <main className="main">
        <header className="topbar">
          <div>
            <h1>{activePage === 'chat' ? 'AI Student Support Assistant' : 'College Notices'}</h1>
            <p>{activePage === 'chat' ? 'Ask questions about your college information' : 'Latest academic and placement updates'}</p>
          </div>
          {activePage === 'chat' && <button className="clear-btn" onClick={clearChat}>Clear chat</button>}
        </header>

        {activePage === 'chat' ? (
          <section className="chat-page">
            <div className="messages">
              {messages.length === 0 ? (
                <div className="welcome">
                  <div className="welcome-icon">🤖</div>
                  <h2>Hello! How can I help you?</h2>
                  <p>Ask me about attendance, exams, syllabus, leave, notices or placements.</p>
                  <div className="quick-grid">
                    {[
                      'What is the attendance requirement?',
                      'When are the semester exams?',
                      'How can I apply for leave?',
                      'Show latest notices'
                    ].map(item => (
                      <button key={item} onClick={() => sendMessage(item)}>{item}</button>
                    ))}
                  </div>
                </div>
              ) : (
                <>
                  {messages.map((m, i) => (
                    <div key={i} className={`message-row ${m.role}`}>
                      <div className={`bubble ${m.role}`}>
                        <div>{m.text}</div>
                        {m.source && <small>📄 Source: {m.source}</small>}
                        {m.role === 'bot' && m.suggestions?.length > 0 && (
                          <div className="suggestions">
                            {m.suggestions.map(s => <button key={s} onClick={() => sendMessage(s)}>{s}</button>)}
                          </div>
                        )}
                      </div>
                    </div>
                  ))}
                  {loading && (
                    <div className="message-row bot">
                      <div className="bubble bot typing">CampusAI is thinking...</div>
                    </div>
                  )}
                </>
              )}
            </div>

            <div className="composer">
              <input
                value={question}
                onChange={e => setQuestion(e.target.value)}
                onKeyDown={e => e.key === 'Enter' && sendMessage()}
                placeholder="Ask your college question..."
              />
              <button onClick={() => sendMessage()} disabled={loading}>Send ➤</button>
            </div>
          </section>
        ) : (
          <section className="notices-page">
            {notices.length === 0 ? <p>No notices available.</p> : notices.map(n => (
              <article className="notice" key={n.id}>
                <div className="notice-top">
                  <span className="tag">{n.category}</span>
                  <span>{n.date}</span>
                </div>
                <h2>{n.title}</h2>
                <p>{n.description}</p>
              </article>
            ))}
          </section>
        )}
      </main>
    </div>
  )
}

export default App

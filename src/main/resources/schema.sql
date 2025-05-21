-- Usuário pode ser aluno ou instrutor
CREATE TABLE users (
id UUID PRIMARY KEY,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
password VARCHAR(255) NOT NULL,
role VARCHAR(20) CHECK (role IN ('STUDENT', 'INSTRUCTOR')) NOT NULL,
created_at TIMESTAMP DEFAULT NOW()
);

-- Curso criado por instrutores
CREATE TABLE courses (
 id UUID PRIMARY KEY,
 title VARCHAR(150) NOT NULL,
 description TEXT,
 instructor_id UUID REFERENCES users(id),
 price DECIMAL(10,2) NOT NULL,
 is_published BOOLEAN DEFAULT FALSE,
 created_at TIMESTAMP DEFAULT NOW()
);

-- Cada curso tem módulos
CREATE TABLE modules (
 id UUID PRIMARY KEY,
 course_id UUID REFERENCES courses(id),
 title VARCHAR(100),
 position INT,
 created_at TIMESTAMP DEFAULT NOW()
);

-- Cada módulo tem aulas
CREATE TABLE lessons (
 id UUID PRIMARY KEY,
 module_id UUID REFERENCES modules(id),
 title VARCHAR(100),
 video_url TEXT,
 duration_minutes INT,
 position INT,
 created_at TIMESTAMP DEFAULT NOW()
);

-- Matrícula do aluno no curso
CREATE TABLE enrollments (
 id UUID PRIMARY KEY,
 student_id UUID REFERENCES users(id),
 course_id UUID REFERENCES courses(id),
 enrollment_date TIMESTAMP DEFAULT NOW(),
 completed BOOLEAN DEFAULT FALSE,
 UNIQUE(student_id, course_id)
);

-- Progresso do aluno nas aulas
CREATE TABLE lesson_progress (
 id UUID PRIMARY KEY,
 enrollment_id UUID REFERENCES enrollments(id),
 lesson_id UUID REFERENCES lessons(id),
 watched BOOLEAN DEFAULT FALSE,
 watched_at TIMESTAMP
);

-- Avaliações
CREATE TABLE reviews (
 id UUID PRIMARY KEY,
 course_id UUID REFERENCES courses(id),
 student_id UUID REFERENCES users(id),
 rating INT CHECK (rating BETWEEN 1 AND 5),
 comment TEXT,
 created_at TIMESTAMP DEFAULT NOW(),
 UNIQUE(course_id, student_id)
);

-- Simulação de pagamento
CREATE TABLE payments (
  id UUID PRIMARY KEY,
  enrollment_id UUID REFERENCES enrollments(id),
  amount DECIMAL(10,2),
  status VARCHAR(20) CHECK (status IN ('PENDING', 'APPROVED', 'FAILED')),
  method VARCHAR(20) CHECK (method IN ('PIX', 'CREDIT_CARD')),
  payment_date TIMESTAMP
);

-- Certificados gerados
CREATE TABLE certificates (
  id UUID PRIMARY KEY,
  enrollment_id UUID REFERENCES enrollments(id),
  generated_at TIMESTAMP DEFAULT NOW(),
  file_url TEXT
);

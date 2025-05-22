CREATE TABLE lessons (
     id UUID PRIMARY KEY,
     module_id UUID REFERENCES modules(id),
     title VARCHAR(100),
     video_url TEXT,
     duration_minutes INT,
     position INT,
     created_at TIMESTAMP DEFAULT NOW()
);
CREATE TABLE search_metadata (
    id VARCHAR(50) PRIMARY KEY,
    status VARCHAR(20),
    json_endpoint VARCHAR(255),
    created_at DATETIME,
    processed_at DATETIME,
    google_scholar_profiles_url VARCHAR(255),
    raw_html_file VARCHAR(255),
    total_time_taken DECIMAL(10, 2)
);

CREATE TABLE search_parameters (
    id INT AUTO_INCREMENT PRIMARY KEY,
    search_metadata_id VARCHAR(50),
    engine VARCHAR(50),
    mauthors VARCHAR(50),
    hl VARCHAR(10),
    FOREIGN KEY (search_metadata_id) REFERENCES search_metadata(id)
);

CREATE TABLE profiles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    search_metadata_id VARCHAR(50),
    name VARCHAR(100),
    link VARCHAR(255),
    serpapi_link VARCHAR(255),
    author_id VARCHAR(50),
    affiliations TEXT,
    email VARCHAR(255),
    cited_by INT,
    thumbnail VARCHAR(255),
    FOREIGN KEY (search_metadata_id) REFERENCES search_metadata(id)
);

CREATE TABLE interests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    profile_id INT,
    title VARCHAR(100),
    serpapi_link VARCHAR(255),
    link VARCHAR(255),
    FOREIGN KEY (profile_id) REFERENCES profiles(id)
);


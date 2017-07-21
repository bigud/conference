package com.testtask.conference.model;

import javax.persistence.*;
import java.io.Serializable;

    @Entity
    @Table(name = "lecture")
    public class Lecture implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private int id;
        @Column(name = "title")
        private String title;
        @Column(name = "content")
        private String content;
        @Column(name = "Lecturer_id")
        private int Lecturer_id;

        public int getLecturer_id() {
            return Lecturer_id;
        }

        public void setLecturer_id(int lecturer_id) {
            Lecturer_id = lecturer_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Lecture{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", Lecturer_id=" + Lecturer_id +
                    '}';
        }
    }

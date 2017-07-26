package com.testtask.conference.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

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
        @ManyToMany
        @JoinColumn(name = "id")
        private Set<User> users;

        public Set<User> getLecturer() {
            return users;
        }

        public void setLecturers(Set<User> users) {
            this.users= users;
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
                    ", Lecturer_id=" + users.toString() +
                    '}';
        }
    }

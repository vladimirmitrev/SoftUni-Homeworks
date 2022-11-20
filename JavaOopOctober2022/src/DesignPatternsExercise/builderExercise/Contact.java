package DesignPatternsExercise.builderExercise;

public class Contact {

    private String name;
    private String number;
    private String company;
    private String title;
    private String email;
    private String website;
    private String birthday;

    public Contact(String name, String number, String company, String title, String email, String website, String birthday) {
        this.name = name;
        this.number = number;
        this.company = company;
        this.title = title;
        this.email = email;
        this.website = website;
        this.birthday = birthday;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().equals("") || name.length() < 2) {
            throw new IllegalStateException("The name must contain at least 2 characters!");
        }

        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number == null || number.trim().equals("") || number.length() < 5) {
            throw new IllegalStateException("The name must contain at least 5 characters!");
        }

        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", company='" + company + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public static class Builder {
        private String name;
        private String number;
        private String company;
        private String title;
        private String email;
        private String website;
        private String birthday;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }
        public Builder withNumber(String number) {
            this.number = number;
            return this;
        }
        public Builder withCompany(String company) {
            this.company = company;
            return this;
        }
        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }
        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder withWebsite(String website) {
            this.website = website;
            return this;
        }
        public Builder withBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public Contact build() {
            return new Contact(name,number,company,title,email,website,birthday);
        }
    }
}

package DesignPatternsExercise.builderExample;

import interfacesAndAbstractionLab.sayHello.Bulgarian;

public class Person {

    private String firstName;
    private String lastName;
    private String address;

    private Person(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String address;

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }
        public Person build() {
            return new Person(firstName, lastName, address);
        }
    }
}

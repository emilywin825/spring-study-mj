package hello.hellospring.controller;

public class MemberForm {
    private String name; //createMemberForm.html에 있는 name="name"의 값이 여기로 들어옴 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
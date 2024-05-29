package com.example.spring_prepare;

import lombok.*;

@Getter
@Setter
// final이 달린 필드를 가지는 생성자를 만들어줌
@RequiredArgsConstructor
// getter, setter 둘다 만들어줌
//@AllArgsConstructor
// 기본 생성자를 만들어줌
//@NoArgsConstructor
public class Memo {
    private String username;
    private String contents;

//    public Memo(String username, String contents) {
//        this.username = username;
//        this.contents = contents;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getUsername() {
//        return this.username;
//    }
}

class Main {
    public static void main(String[] args) {
        Memo memo = new Memo();
        memo.setUsername("Robbie");
        System.out.println(memo.getUsername());
    }
}
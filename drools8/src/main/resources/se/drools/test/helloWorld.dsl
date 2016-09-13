[condition][]Есть сообщение со статусом "{test}"=m : Message(status == {test});
[consequence][]Напечатай все сообщение=System.out.println(m.getMessage() + ":" + m.getStatus());

[condition][]Есть сообщение=m : Message();
[consequence][]Напечатай=System.out.println(m.getMessage());


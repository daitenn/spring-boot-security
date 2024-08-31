insert into issues (summary, description) values ('バグA', 'バグがあります');
insert into issues (summary, description) values ('機能要望B', 'Bに追加機能がほしいです');
insert into issues (summary, description) values ('画面Cが遅い', '早くしてほしいです');


-- password1234
insert into users (username, password, authority) values ('tom', 'a1d09d08f66a72c98da1a942fc2d8f9f2ac6e29b7b79a22b8ca61e7160725f4f69ba45063eacd7c7', 'ADMIN');
insert into users (username, password, authority) values ('bbb', 'b0546826717122a2fd1fe7771d9f2e61fd53e81da94ba3aada0688be04f118a1f3983b2d4ccf6ed2', 'USER');
test("test", () => {
    const record = [
        "Enter uid1234 Muzi",
        "Enter uid4567 Prodo",
        "Leave uid1234",
        "Enter uid1234 Prodo",
        "Change uid4567 Ryan"
    ];

    expect(solution(record)).toEqual([
        "Prodo님이 들어왔습니다.",
        "Ryan님이 들어왔습니다.",
        "Prodo님이 나갔습니다.",
        "Prodo님이 들어왔습니다."
    ]);
});

function solution(record) {
    const chat = [];
    const nicknames = {};

    record.forEach(msg => {
        let [status, uid, nickname] = msg.split(" ");

        if (status === "Leave") {
            chat.push([uid, "님이 나갔습니다."]);
        } else if (status === "Enter") {
            chat.push([uid, "님이 들어왔습니다."]);
            nicknames[uid] = nickname;
        } else {
            nicknames[uid] = nickname;
        }
    });

    return chat.map(msg => {
        return nicknames[msg[0]] + msg[1];
    });
}

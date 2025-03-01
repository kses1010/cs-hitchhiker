test("test", () => {
  const fee1 = [180, 5000, 10, 600];
  const records1 = [
    "05:34 5961 IN",
    "06:00 0000 IN",
    "06:34 0000 OUT",
    "07:59 5961 OUT",
    "07:59 0148 IN",
    "18:59 0000 IN",
    "19:09 0148 OUT",
    "22:59 5961 IN",
    "23:00 5961 OUT"
  ];

  const fee2 = [120, 0, 60, 591];
  const records2 = [
    "16:00 3961 IN",
    "16:00 0202 IN",
    "18:00 3961 OUT",
    "18:00 0202 OUT",
    "23:58 3961 IN"
  ];

  const fee3 = [1, 461, 1, 10];
  const records3 = ["00:00 1234 IN"];

  expect(solution(fee1, records1)).toEqual([14600, 34400, 5000]);
  expect(solution(fee2, records2)).toEqual([0, 591]);
  expect(solution(fee3, records3)).toEqual([14841]);
});

function solution(fee, records) {
  const cars = {};
  records.forEach(record => {
    let [time, car, parkingStatus] = record.split(" ");
    const [hour, minute] = time.split(":");

    time = hour * 60 + Number(minute);

    if (!cars[car]) {
      cars[car] = {car, time: 0, lastInTime: 0};
    }

    cars[car].parkingStatus = parkingStatus;

    if (parkingStatus === "OUT") {
      cars[car].time += time - cars[car].lastInTime;
    } else {
      cars[car].lastInTime = time;
    }
  });

  return Object.values(cars)
    .sort((a, b) => a.car - b.car)
    .map(info => {
      if (info.parkingStatus === "IN") {
        info.time += 1439 - info.lastInTime;
      }

      if (info.time <= fee[0]) {
        return fee[1];
      }

      return fee[1] + Math.ceil((info.time - fee[0]) / fee[2]) * fee[3];
    });
}

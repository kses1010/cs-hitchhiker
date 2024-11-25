test("test", () => {
  let cacheSize1 = 3;
  const cities1 = ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"];

  let cacheSize2 = 3;
  const cities2 = ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"];

  let cacheSize3 = 2;
  const cities3 = ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris",
    "Jeju", "NewYork", "Rome"];

  let cacheSize4 = 5;
  const cities4 = ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris",
    "Jeju", "NewYork", "Rome"];

  let cacheSize5 = 2;
  const cities5 = ["Jeju", "Pangyo", "NewYork", "newyork"];

  let cacheSize6 = 0;
  const cities6 = ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"];

  expect(solution(cacheSize1, cities1)).toBe(50);
  expect(solution(cacheSize2, cities2)).toBe(21);
  expect(solution(cacheSize3, cities3)).toBe(60);
  expect(solution(cacheSize4, cities4)).toBe(52);
  expect(solution(cacheSize5, cities5)).toBe(16);
  expect(solution(cacheSize6, cities6)).toBe(25);
})

function solution(cacheSize, cities) {
  let answer = 0;
  if (cacheSize === 0) {
    return cities.length * 5;
  }
  const cache = [];

  for (const s of cities) {
    let city = s.toLowerCase();
    let index = cache.indexOf(city);
    if (index !== -1) {
      cache.splice(index, 1);
      answer += 1;
    } else {
      if (cache.length >= cacheSize) {
        cache.shift();
      }
      answer += 5;
    }

    cache.push(city);
  }

  return answer;
}

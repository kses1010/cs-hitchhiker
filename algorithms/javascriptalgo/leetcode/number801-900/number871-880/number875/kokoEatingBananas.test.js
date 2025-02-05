test("test", () => {
  const piles1 = [3, 6, 7, 11];
  const h1 = 8;

  const piles2 = [30, 11, 23, 4, 20];
  const h2 = 5;

  const piles3 = [30, 11, 23, 4, 20];
  const h3 = 6;

  expect(minEatingSpeed(piles1, h1)).toEqual(4);
  expect(minEatingSpeed(piles2, h2)).toEqual(30);
  expect(minEatingSpeed(piles3, h3)).toEqual(23);
});

/**
 * @param {number[]} piles
 * @param {number} h
 * @return {number}
 */
const minEatingSpeed = function(piles, h) {
  let low = 1;
  let high = Math.max(...piles);

  const canFinish = (speed) => {
    let hours = 0;
    for (const pile of piles) {
      hours += Math.ceil(pile / speed);
    }
    return hours <= h;
  }

  while (low < high) {
    const mid = Math.floor(low + (high - low) / 2);

    if (canFinish(mid)) {
      high = mid;
    } else {
      low = mid + 1;
    }
  }
  return low;
};

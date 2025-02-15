test("test", () => {
  const skill = "CBD";
  const skillTrees = ["BACDE", "CBADF", "AECB", "BDA"];

  expect(solution(skill, skillTrees)).toEqual(2);

});

function solution(skill, skillTrees) {
  let answer = 0;
  const skillMap = {};

  for (let i = 0; i < skill.length; i++) {
    skillMap[skill[i]] = i;
  }

  const isSkillTree = (checkList) => {
    for (let i = 0; i < checkList.length; i++) {
      if (checkList[i] !== i) {
        return false;
      }
    }
    return true;
  }

  for (const tree of skillTrees) {
    const checkList = [];

    for (const sk of tree) {
      if (skillMap.hasOwnProperty(sk)) {
        checkList.push(skillMap[sk]);
      }
    }

    if (isSkillTree(checkList)) answer++;
  }

  return answer;
}

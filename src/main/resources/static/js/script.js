console.log("Script Loaded");

let currentTheme = getTheme();

function toggleTheme() {
  document.querySelector("html").classList.add(currentTheme);
  const changeThemeButton = document.querySelector("#theme-toggle");
  const oldTheme = currentTheme;
  if (currentTheme === "dark") {
    currentTheme = "light";
  } else {
    currentTheme = "dark";
  }
  setTheme(currentTheme);
  document.querySelector("html").classList.remove(oldTheme);
  document.querySelector("html").classList.add(currentTheme);
  changeThemeButton.querySelector("span").textContent =
    currentTheme === "dark" ? "Light" : "Dark";
}

function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

function getTheme() {
  let theme = localStorage.getItem("theme");
  return theme ? theme : "light";
}

document.getElementById("theme-toggle").addEventListener("click", toggleTheme);

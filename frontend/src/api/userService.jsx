const userService = {
  async getUserData() {
    const response = await fetch("http://localhost:8080/api/v1/user/getUser", {
      method: "GET",
      headers: { "Content-Type": "application/json" },
      credentials: "include",
    });
    return await response.json();
  },

  async logout() {
    const response = await fetch("http://localhost:8083/api/v1/auth/logout", {
      method: "GET",
      headers: { "Content-Type": "application/json" },
      credentials: "include",
    });
  },
};

export default userService;

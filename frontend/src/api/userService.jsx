const userService = {
  async getUserData() {
    const res = await fetch("http://localhost:8080/api/v1/user/getUser", {
      method: "GET",
      credentials: "include",
    });
    if (res.status === 403) {
      throw new Error("Unauthorized or token invalid");
    }
  
    if (res.ok) {
      return res.json();
    } else {
      return null;
    }
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

const cartService = {
  async getCart() {
    const response = await fetch(
      "http://localhost:8085/api/v1/cart/getCartById",
      {
        method: "GET",
        credentials: "include",
      }
    );

    if (!response.ok) {
      let errorMessage = "Fetch failed";
      try {
        const errorData = await response.json();
        errorMessage = errorData.message || errorMessage;
      } catch (e) {}
      throw new Error(errorMessage);
    }

    return await response.json();
  },
};

export default cartService;

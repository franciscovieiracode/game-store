import { createContext, useContext, useEffect, useState } from "react";
import cartService from "../api/cartService";

const CartContext = createContext();

export const CartProvider = ({ children }) => {
  const [items, setItems] = useState([]);
  const [totalQuantity, setTotalQuantity] = useState(0);

  useEffect(() => {
    const fetchedData = async () => {

        const data = await cartService.getCart()
        setItems(data)
        calculateCartTotals(data)

    }; fetchedData();
  },[]);

  const calculateCartTotals = (cartItems) => {    
    const quantity = cartItems.reduce((sum, item) => sum + item.quantity, 0);
    setTotalQuantity(quantity);
  };

  return (
    <CartContext.Provider value={{ items, totalQuantity }}>
      {children}
    </CartContext.Provider>
  );
};

export const useCart = () => {
  const context = useContext(CartContext);
  if (!context) {
    throw new Error("useCart must be used within a CartProvider");
  }
  return context;
};

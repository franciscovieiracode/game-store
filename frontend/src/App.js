import { Navbar } from "./components/navbar/Navbar";
import { Home } from "./pages/Home";
import { Login } from "./pages/Login";
import { Signup } from "./pages/Signup";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { ShopCategory } from "./pages/ShopCategory";
import { GameDetail } from "./pages/GameDetail";
import { Cart } from "./pages/Cart";
import { Footer } from "./components/footer/Footer";
import { UserProvider } from "./contexts/UserContext";
import { CartProvider } from "./contexts/CartContext";

const App = () => {
  return (
    <UserProvider>
      <CartProvider>
        <BrowserRouter>
          <Navbar></Navbar>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/:category" element={<ShopCategory />} />
            <Route path="/game" element={<GameDetail />}>
              <Route path=":gameId" element={<GameDetail />}></Route>
            </Route>
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Signup />} />
            <Route path="/cart" element={<Cart />} />
          </Routes>
          <Footer></Footer>
        </BrowserRouter>
      </CartProvider>
    </UserProvider>
  );
};

export default App;

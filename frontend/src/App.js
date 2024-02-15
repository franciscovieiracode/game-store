import { Navbar } from "./components/navbar/Navbar";
import {Home} from './pages/Home'
import {Login} from './pages/Login'
import {
  BrowserRouter,
  Route,
  Routes,
} from "react-router-dom";
import { ShopCategory } from "./pages/ShopCategory";
import { Game } from "./pages/Game";
import { Cart } from "./pages/Cart";


const App =() => {
  return (
<BrowserRouter>
      <Navbar></Navbar>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/pc" element={<ShopCategory category="pc"/>} />
        <Route path="/playstation" element={<ShopCategory category="playstation" />} />
        <Route path="/xbox" element={<ShopCategory category="xbox"/>} />
        <Route path="/game" element={<Game/>}>
          <Route path=":gameId" element={<Game/>}></Route>
        </Route>
        <Route path="/login" element={<Login />} />
        <Route path="/cart" element={<Cart />} />
      </Routes>
    </BrowserRouter>  );
}

export default App;

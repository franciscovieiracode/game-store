import { React, useEffect, useState } from "react";
import catalogService from "../api/catalogService";
import { useParams } from "react-router-dom";
import { Game } from "../components/game/Game";
import "./css/ShopCategory.css";

export const ShopCategory = () => {
  const { category } = useParams();
  const [games, setGames] = useState([]);

  useEffect(() => {
    if (category) {
      const param = category.toUpperCase();
      catalogService
        .findByCategory(category)
        .then((response) => {
          setGames(response);
        })
        .catch((error) => {
          console.error("Error fetching category:", error);
        });
    }
  }, [category]);

  return (
    <div className="cat">
      <h3>{category} GAMES</h3>
      <hr />
      <div className="cat-games">
  {games.map((game, i) => {
    console.log(game);

    const price = game.gamePlatformModels[0].price;
    const discount = game.gamePlatformModels[0].discount;

    const newPrice = (price - discount).toFixed(2);
    const oldPrice = price.toFixed(2);

    return (
      <div className="game-item" key={i}>
        <Game
          id={game.gameId}
          name={game.name}
          image={game.gameImg}
          new_price={newPrice}
          old_price={oldPrice}
        />
      </div>
    );
  })}
</div>

    </div>
  );
};

import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import '../pages/css/GameDetail.css';
import heart from '../components/assets/heart.png';
import gameService from '../api/catalogService';

export const GameDetail = () => {
  const [selectedConsole, setSelectedConsole] = useState('');
  const [gameData, setGameData] = useState(null); // Store the fetched game data
  const [loading, setLoading] = useState(true); // Track loading state
  const [currentPrice, setCurrentPrice] = useState(null); // Store current price for selected platform
  const { gameId } = useParams(); // Get the game ID from URL

  // Handle change in selected platform (console)
  const handleConsoleChange = (event) => {
    const selected = event.target.value;
    setSelectedConsole(selected);
    
    // Find the price for the selected platform
    const selectedPlatform = gameData.gamePlatformModels.find(
      (platform) => platform.platformModel.platformEnums === selected
    );
    setCurrentPrice(selectedPlatform);
  };

  // Fetch game data on component mount
  useEffect(() => {
    const fetchGameData = async () => {
      try {
        const data_games = await gameService.findById(gameId);
        setGameData(data_games);
        setLoading(false);
        
        // Set the default selected platform to the first platform
        const defaultPlatform = data_games.gamePlatformModels[0].platformModel.platformEnums;
        setSelectedConsole(defaultPlatform);
        setCurrentPrice(data_games.gamePlatformModels[0]); // Default to the first platform
      } catch (err) {
        console.error(err);
      }
    };

    fetchGameData();
  }, [gameId]);

  // Loading state
  if (loading) {
    return <div>Loading...</div>;
  }

  // If no data is found, show a message
  if (!gameData) {
    return <div>Game details not found.</div>;
  }

  return (
    <div className="game-detail">
      <div className="left">
        <div className="big-image">
          <img src={gameData.gameImg} alt="Game Image" />
        </div>
        <div className="description">
          <h2>ABOUT</h2>
          <p>{gameData.description}</p>
        </div>
      </div>
      <div className="right">
        <div className="info">{gameData.name}</div>
        <div className="console">
          <select
            value={selectedConsole}
            onChange={handleConsoleChange}
            className="console-dropdown"
          >
            {gameData.gamePlatformModels.map((platform) => (
              <option key={platform.gamePlatformId} value={platform.platformModel.platformEnums}>
                {platform.platformModel.platformEnums}
              </option>
            ))}
          </select>
        </div>
        <div className="prices">
          {currentPrice ? (
            <>
              <p className="old-price">{currentPrice.price}€</p>
              <p className="percentage">-{Math.round((currentPrice.discount / currentPrice.price) * 100)}%</p>
              <p className="new-price">{(currentPrice.price - currentPrice.discount).toFixed(2)}€</p>
            </>
          ) : (
            <div>No price available for the selected platform</div>
          )}
        </div>
        <div className="btnfav">
          <button>Add to cart</button>
        </div>
        <div className="tags">
          <div className="dev-details">
            <p>Developer: <a>{gameData.developer}</a></p>
            <p>Publisher: <a>{gameData.publisher}</a></p>
          </div>
          <div className="details">
            Release date: {gameData.releaseDate}
          </div>
        </div>
      </div>
    </div>
  );
};

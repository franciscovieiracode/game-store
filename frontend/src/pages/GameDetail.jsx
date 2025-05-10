import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';  
import data_game from '../components/assets/data single';
import '../pages/css/GameDetail.css';
import heart from '../components/assets/heart.png';
import gameService from '../api/catalogService'


export const GameDetail = () => {
  const [selectedConsole, setSelectedConsole] = useState('');
  const { gameId } = useParams();  
  const [gameData, setGameData] = useState(null);  // Store the fetched game data

  const [loading, setLoading] = useState(true);  // Track loading state


  const handleConsoleChange = (event) => {
    setSelectedConsole(event.target.value);
  };

  const teste = () => {
    alert(`Added to cart for ${selectedConsole}`);
  };

  useEffect(() => {
    const fetchGameData = async () => {
      try {
          const data_games = await gameService.findById(gameId);
          console.log(data_games)
          
          setGameData(data_games); 
          setLoading(false); 
      } catch (err) {
         
      }
  };

    fetchGameData();
  }, [gameId]); 

  if (loading) {
    return <div>Loading...</div>;
  }

  // If no data available, show a message
  if (!gameData) {
    return <div>Game details not found.</div>;
  }

  return (
    <div className='game-detail'>
      <div className="left">
        <div className="big-image">
          <img src={data_game.small_images[0]} alt="Game Image" />
        </div>
        <div className="small-image">
          <img src={data_game.small_images[0]} alt="" />
          <img src={data_game.small_images[0]} alt="" />
          <img src={data_game.small_images[1]} alt="" />
        </div>
        <div className="description">
          <h2>ABOUT</h2>
          <p>{gameData.description}</p>
        </div>
      </div>
      <div className="right">
        <div className="info">
          {gameData.name}
        </div>
        <div className="console">
          <select value={selectedConsole} onChange={handleConsoleChange} className="console-dropdown">
            <option value="">Select Platform</option>
            {data_game.console.map((console, index) => (
              <option key={index} value={console}>
                {console}
              </option>
            ))}
          </select>
        </div>
        <div className="prices">
        <p className='old-price'>{gameData.gamePlatformModels[0].price}€</p>
          <p className='percentage'>-30%</p>
          <p className='new-price'>{gameData.gamePlatformModels[0].price }€</p>
        </div>
        <div className="btnfav">
          <img src={heart} height={25} alt="" />
          <button onClick={teste}>Add to cart</button>
        </div>
        <div className="tags">
          <div className="genre">
          Genre: {data_game.genre.map((tag, index) => (
            <a key={index}>
              {tag}
              {index !== data_game.genre.length - 1 && ', '}
            </a>
          ))}
          </div>
          <div className="dev-details">
            <p>Developer: <a>{gameData.developer}</a> </p>
            <p>Publisher: <a>{gameData.publisher}</a> </p>
          </div>
          <div className="details">
            Release date: {gameData.releaseDate}
          </div>
        </div>
      </div>
    </div>
  );
};

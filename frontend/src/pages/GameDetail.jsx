import React, { useState } from 'react';
import data_game from '../components/assets/data single';
import '../pages/css/GameDetail.css';
import heart from '../components/assets/heart.png';

export const GameDetail = () => {
  const [selectedConsole, setSelectedConsole] = useState('');

  const handleConsoleChange = (event) => {
    setSelectedConsole(event.target.value);
  };

  const teste = () => {
    alert(`Added to cart for ${selectedConsole}`);
  };

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
          <p>{data_game.about}</p>
        </div>
      </div>
      <div className="right">
        <div className="info">
          {data_game.name}
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
        <p className='old-price'>{data_game.old_price}€</p>
          <p className='percentage'>-30%</p>
          <p className='new-price'>{data_game.new_price}€</p>
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
            <p>Developer: <a>{data_game.developer}</a> </p>
            <p>Publisher: <a>{data_game.publisher}</a> </p>
          </div>
          <div className="details">
            Release date: {data_game.release_date}
          </div>
        </div>
      </div>
    </div>
  );
};

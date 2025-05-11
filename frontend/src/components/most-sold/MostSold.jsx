import {React, useState ,useEffect } from 'react'
import './MostSold.css'
import { Game } from '../game/Game'
import gameService from '../../api/catalogService'

export const MostSold = () => {

    const [games, setGames] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchGames = async () => {
            try {
                const data_games = await gameService.getMostSoldGames();
                setGames(data_games); 
                setLoading(false); 
            } catch (err) {
                setError(err.message);
                setLoading(false);
            }
        };

        fetchGames(); 
    }, []); 

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div className='sold'>
            <h1>MOST SOLD GAMES</h1>
            <hr />
            <div className="sold-games">
                {games.map((game, i) => {
                    console.log(game);
                    
                    const price = game.gamePlatformModels[0].price;
                    const discount = game.gamePlatformModels[0].discount;
                    
                    const newPrice = (price - discount).toFixed(2); 
    
                    const oldPrice = price.toFixed(2); 
    
                    return (
                        <Game 
                            key={i} 
                            id={game.gameId} 
                            name={game.name} 
                            image={game.gameImg}
                            new_price={newPrice} 
                            old_price={oldPrice} 
                        />
                    );
                })}
            </div>
        </div>
    );
}

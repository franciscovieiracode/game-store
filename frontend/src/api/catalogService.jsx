const catalogService = {

    async getAllGames() {
        const response = await fetch("http://localhost:8084/api/v1/catalog/getAllCatalog", {
            method: "GET",
        });

        if (!response.ok) {
            let errorMessage = 'Fetch failed';
            try {
                const errorData = await response.json();
                errorMessage = errorData.message || errorMessage;
            } catch (e) {
            }
            throw new Error(errorMessage);
        }

        return await response.json();
    },

    async findById(gameId){
        const response = await fetch(`http://localhost:8084/api/v1/catalog/findById/${gameId}`, {
            method: "GET",
            headers: {
                'Content-Type': 'application/json', 
              }
        });

        if (!response.ok) {
            let errorMessage = 'Fetch failed';
            try {
                const errorData = await response.json();
                errorMessage = errorData.message || errorMessage;
            } catch (e) {
            }
            throw new Error(errorMessage);
        }

        return await response.json();
    }

}

export default catalogService;

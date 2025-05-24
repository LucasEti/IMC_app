
export async function fetchHistorique() {
  try {
    const response = await fetch("http://localhost:8080/imc/history");
    if (!response.ok) {
      throw new Error("Erreur réseau lors du chargement de l'historique");
    }
    const data = await response.json();
    return data;  
  } catch (error) {
    console.error("Erreur lors du chargement de l'historique :", error);
    throw error;  
  }
}
export default fetchHistorique;


export async function fetchDelete(id,setHistorique) { 
    try {
      const url= id ?
      `http://localhost:8080/imc/delete/${id}` :
      `http://localhost:8080/imc/delete`;
      
      const response = await fetch(url, {
        method: "DELETE",
      });
      if (!response.ok) {
        throw new Error("Erreur lors de la suppression de l'historique");
      }
      if (id) {
        setHistorique((prev) => prev.filter((item) => item.id !== id));
      }
      else {
        setHistorique([]);
      }
    } catch (error) {
      console.error(error);
    }
  };



export async function fetchPost(poids,taille,setResultat,setErreur,setHistorique) {
    const requestData = { poids, taille };
    try {
      const response = await fetch("http://localhost:8080/imc/calculate", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(requestData),
      });
      if (!response.ok) {
        throw new Error("Erreur lors de la sauvegarde du calcul");
      }
      const data = await response.json();
      console.log("id:",data.id);
      console.log("Données reçues :", data); 
      setResultat(data);
      setErreur(null);
      setHistorique((prev) => [data, ...prev]);
    } catch (error) {
      setErreur(error.message);
      setResultat(null);
    }
}




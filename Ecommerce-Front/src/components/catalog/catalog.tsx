import './catalog.css'

interface CatalogProps {
    nome: string, 
    image: string,
    val_prod: number
}

export function Catalog({nome, image, val_prod} : CatalogProps){
    return(
    <>
        
        <img src={image}/>
        
        <h2>{nome}</h2>
        <p>Valor: {val_prod}</p>
        
    </>
    )
}

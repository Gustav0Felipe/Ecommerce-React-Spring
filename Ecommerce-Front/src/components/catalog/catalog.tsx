import { Link } from 'react-router-dom'
import './catalog.css'

interface CatalogProps {
    id_prod: any,
    nome: string, 
    image: string,
    val_prod: number
}

export function Catalog({id_prod, nome, image, val_prod} : CatalogProps){
    return(
    <>
        <Link to={"/comprar" + "/" + id_prod} ><img src={image}/></Link>
        <h2>{nome}</h2>
        <p>Valor: {val_prod}</p>
    </>
    )
}

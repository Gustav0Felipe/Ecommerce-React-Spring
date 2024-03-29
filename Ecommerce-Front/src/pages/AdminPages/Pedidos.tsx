import { Link, Navigate } from "react-router-dom";
import { Footer } from "../../components/footer/footer";
import Header from "../../components/header/header";
import { usePedidosData } from "../../hooks/usePedidoDataList";
import { useState } from "react";
import Select from "react-select";


const months = [
    { value: "01", label: "Janeiro" },
    { value: "02", label: "Fevereiro" },
    { value: "03", label: "Março" },
    { value: "04", label: "Abril" },
    { value: "05", label: "Maio" },
    { value: "06", label: "Junho" },
    { value: "07", label: "Julho" },
    { value: "08", label: "Agosto" },
    { value: "09", label: "Setembro" },
    { value: "10", label: "Outubro" },
    { value: "11", label: "Novembro" },
    { value: "12", label: "Dezembro" }
  ];
const years = [
    {value : "2022", label: "2022"},
    {value : "2023", label: "2023"},
    {value : "2024", label: "2024"}
];
export function Pedidos(){
    const [selectedYear, setSelectedYear] = useState<any>();
    const [selectedMonth, setSelectedMonth] = useState<any>();
    const { data } =  usePedidosData();


    const limparFiltro = () =>{
        setSelectedYear(null);
        setSelectedMonth(null);
    }

    return(
    <>
    {window.sessionStorage.getItem("isAdmin") != "true" && <Navigate to="/loja/login"></Navigate> }
    <Header></Header>

    <section id="section-principal">

        <Select
            placeholder="Selecionar Mês"
            value={selectedMonth}
            onChange={setSelectedMonth}
            isClearable options={months}
        />
        <Select
            placeholder="Selecionar Ano"
            value={selectedYear}
            onChange={setSelectedYear}
            isClearable options={years}
        />
        <button onClick={limparFiltro}>Limpar Filtro</button>
        <div>
            <table className="pedidos">
                <tbody>
                <tr className="pedido">
                    <th scope="col">Pedido</th> 
                    <th scope="col">Cliente</th> 
                    <th scope="col">Data inicial</th> 
                    <th scope="col">Data Final</th> 
                    <th scope="col">Valor Total</th> 
                    <th scope="col">Status</th> 
                    <th scope="col"></th>
                </tr> 
                { 
                data?.map((pedidoData) => {
                if (selectedMonth == null && selectedYear == null || 
                    (selectedMonth != null && selectedYear != null && pedidoData.data_inicial.substring(5, 7).includes(selectedMonth.value)) && pedidoData.data_inicial.substring(0, 4).includes(selectedYear.value) ||
                    (selectedMonth != null && selectedYear == null && pedidoData.data_inicial.substring(5, 7).includes(selectedMonth.value)) || 
                    (selectedYear != null && selectedMonth == null && pedidoData.data_inicial.substring(0, 4).includes(selectedYear.value))) {
                return <tr className="pedido" key={pedidoData.num_ped}>
                    <td>{pedidoData.num_ped}</td> 
                    <td>{pedidoData.cod_cli.cod_cli} </td>
                    <td>{pedidoData.data_inicial} </td>
                    <td>{pedidoData.data_final} </td>
                    <td>{pedidoData.valor_total}</td>
                    <td>{pedidoData.status_ped} </td>
                    <td>
                        <Link to={"/loja/admin/pedidos/" + pedidoData.num_ped} className="buttonLink"> 
                        <span className="material-symbols-outlined">arrow_forward</span>
                        </Link>
                    </td>
                    </tr>
                } 
            return null;
            })
            } 
                </tbody>
            </table>
        
            <Link to="/loja/admin" className="buttonLink">
                <button className="voltar">
                    <span className="material-symbols-outlined">
                        arrow_back
                    </span>
                </button>
            </Link>
        </div>
        
    </section>

    <Footer></Footer>
    </>
    )
}
package com.example.mobilebip.model

var resources = mapOf(
    "00102" to "PCP",
    "00103" to "Engenharia",
    "00105" to "Aguardando Componentes",
    "00106" to "Aguardando MP",
    "00107" to "Processo de Compras",
    "00201" to "Controle de Produção",
    "00210" to "Torno Mecânico 01",
    "00220" to "Torno Mecânico 02",
    "00230" to "Torno Mecânico 03",
    "00240" to "Torno Mecânico 04",
    "00250" to "Torno Mecânico 05",
    "00260" to "Ilha Torno Mecânico",
    "00410" to "Plâina",
    "00610" to "Fresa",
    "00650" to "Ilha Fresa",
    "01410" to "Furadeira",
    "02910" to "Brochadeira",
    "03010" to "Nardini 01",
    "03020" to "Nardini 02",
    "03030" to "Nardini 03",
    "03110" to "Centro de Usinagem",
    "03410" to "Index 01",
    "03420" to "Index 02",
    "03430" to "Index 03",
    "03440" to "Ilha T CNC",
    "03810" to "Serra",
    "03820" to "Serra Caixa",
    "04510" to "Solda",
    "05001" to "Controle de Qualidade",
    "05004" to "PI Aguardando PI's",
    "05005" to "Garantia",
    "07001" to "Lubrificação",
    "07101" to "Embalagem",
    "07501" to "Tratamento Térmico",
    "07601" to "Retorno do Tratamento Térmico",
    "09502" to "Serviço Terceirizado"
)

fun hasResource (code: String) : Int {
    return if (resources.containsKey(code)) {
        1
    } else {
        -1
    }
}

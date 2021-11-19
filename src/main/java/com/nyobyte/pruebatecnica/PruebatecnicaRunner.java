package com.nyobyte.pruebatecnica;

import com.nyobyte.pruebatecnica.model.dao.EntidadEntity;
import com.nyobyte.pruebatecnica.model.dao.TipoContribuyenteEntity;
import com.nyobyte.pruebatecnica.model.dao.TipoDocumentoEntity;
import com.nyobyte.pruebatecnica.model.repositories.EntidadRepository;
import com.nyobyte.pruebatecnica.model.repositories.TipoContribuyenteRepository;
import com.nyobyte.pruebatecnica.model.repositories.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PruebatecnicaRunner implements CommandLineRunner {
    @Autowired
    private EntidadRepository entidadRep;
    @Autowired
    private TipoContribuyenteRepository tipoContribRep;
    @Autowired
    private TipoDocumentoRepository tipoDocRep;


    @Override
    public void run(String... args) throws Exception {
        // TIPOS DE DOCUMENTOS:
        TipoDocumentoEntity doc1 = new TipoDocumentoEntity(null, "4", "CARNET DE EXTRANJERIA", "CARNET DE EXTRANJERIA", true);
        TipoDocumentoEntity doc2 = new TipoDocumentoEntity(null, "7", "PASAPORTE", "PASAPORTE", true);
        TipoDocumentoEntity doc3 = new TipoDocumentoEntity(null, "11", "PARTIDA DE NACIMIENTO - IDENTIDAD", "PARTIDA DE NACIMIENTO - IDENTIDAD", true);
        TipoDocumentoEntity doc4 = new TipoDocumentoEntity(null, "99", "OTROS", "OTROS", true);
        TipoDocumentoEntity doc5 = new TipoDocumentoEntity(null, "6", "RUC", "REGISTRO UNICO DEL CONTRIBUYENTE", true);
        TipoDocumentoEntity doc6 = new TipoDocumentoEntity(null, "1", "DNI", "DOCUMENTO NACIONAL DE IDENTIDAD", true);
        tipoDocRep.save(doc1);
        tipoDocRep.save(doc2);
        tipoDocRep.save(doc3);
        tipoDocRep.save(doc4);
        tipoDocRep.save(doc5);
        tipoDocRep.save(doc6);
        // TIPOS DE CONTRIBUYENTES:
        TipoContribuyenteEntity contrib1 = new TipoContribuyenteEntity(null, "Natural Sin Negocio", true);
        TipoContribuyenteEntity contrib2 = new TipoContribuyenteEntity(null, "Juridica", true);
        TipoContribuyenteEntity contrib3 = new TipoContribuyenteEntity(null, "Natural Con Negocio", true);
        TipoContribuyenteEntity contrib4 = new TipoContribuyenteEntity(null, "No Domiciliado", true);
        tipoContribRep.save(contrib1);
        tipoContribRep.save(contrib2);
        tipoContribRep.save(contrib3);
        tipoContribRep.save(contrib4);
        // ENTIDADES:
        EntidadEntity e1 = new EntidadEntity(null,
                "20505327552", "SYL S.A.C", "SYL CARGO NOMBRE COMERCIAL",
                "Jr. Comandante Jimenez Nro. 166 Int. a (entre Cuadra 7 y 8 Javier Padro Oeste)",
                "79845612", true, doc3, contrib1);
        EntidadEntity e2 = new EntidadEntity(null,
                "20543844838", "PUNTUAL EXPRESS S.A.C.", null,
                "'MZA. F LOTE. 29 AS.RSD.MONTECARLO II LIMA - LIMA - SAN MARTIN DE PORRE",
                null, true, doc3, contrib1);
        EntidadEntity e3 = new EntidadEntity(null,
                "10410192999", "ALVAREZ MACHUCA RENZO GUSTAVO", null,
                "AV. LOS ALISOS MZA. G LOTE. 05 ASC. LA ALBORADA DE OQUENDO III ETAPA (CRUCE PTE OQUENDO CON AV.NESTOR GAMBETTA) PROV. CONST. DEL CALLAO - PROV. CONST. DEL CALLAO - CALLAO",
                null, true, doc3, contrib3);
        EntidadEntity e4 = new EntidadEntity(null,
                "20600131037", "CARNICOS MAFER S.A.C.", null,
                "CAL.EL UNIVERSO NRO. 327 URB. LA CAMPIÑA ZONA CINCO (ALTURA ",
                null, true, doc3, contrib2);
        EntidadEntity e5 = new EntidadEntity(null,
                "20556528218", "SUMAQUINARIA S.A.C.", null,
                "AV. M.SUCRE NRO. 455 DPTO. 603 LIMA - LIMA - MAGDALENA DEL MAR",
                null, true, doc3, contrib2);
        EntidadEntity e6 = new EntidadEntity(null,
                "20545412528", "OASIS FOODS S.A.C.", null,
                "CAL. FRANCISCO MASIAS NRO. 370 URB. SAN EUGENIO (PISO 7) LIM",
                null, true, doc3, contrib2);
        EntidadEntity e7= new EntidadEntity(null,
                "20510620195", "INVERSIONES PRO3 SAC", null,
                "AV. AUTOPIDTA RAMIRO PRIALE LOTE. 02 A.V. PROP HUERTOS DE HU",
                null, true, doc3, contrib2);
        EntidadEntity e8 = new EntidadEntity(null,
                "20498383361", "REPUESTOS DAVID DIESEL E.I.R.L.", null,
                "CAR.VIA EVITAMIENTO MZA. 857 LOTE. 7 SEC. IRRIGACION EL CURAL 1 AREQUIPA - AREQUIPA - CERRO COLORADO",
                null, true, doc3, contrib2);
        EntidadEntity e9 = new EntidadEntity(null,
                "CNAH00003", "ANHUI HAYVO PROTECTIVE PRODUCT MANUFACTURING CO.,LTD", null,
                "173 FENGLE AVENUE,ECNOMIC DEVELOPMENT ZONE,QUANJIAO COUNTY",
                null, true, doc6, contrib4);
        entidadRep.save(e1);
        entidadRep.save(e2);
        entidadRep.save(e3);
        entidadRep.save(e4);
        entidadRep.save(e5);
        entidadRep.save(e6);
        entidadRep.save(e7);
        entidadRep.save(e8);
        entidadRep.save(e9);
    }
}

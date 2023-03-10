package com.igac.generarusohddram.services.impl;

import com.igac.generarusohddram.models.Estadistica;
import com.igac.generarusohddram.services.StatService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class StatServiceImpl implements StatService {

    DecimalFormat format = new DecimalFormat("#,00");

    @Override
    public Estadistica obtenerRamHdd() {
        File[] unidades = File.listRoots();
        final double capacidadTotal = bytesToGigaBytes( unidades[1].getTotalSpace() );
        final double espacioLibre = bytesToGigaBytes( unidades[1].getFreeSpace() );
        final double espacioOcupado = bytesToGigaBytes( unidades[1].getTotalSpace() - unidades[1].getFreeSpace() );

        return new Estadistica(
                capacidadTotal,
                espacioLibre,
                espacioOcupado,
                Double.parseDouble( format.format(  bytesToMegabytes( Runtime.getRuntime().totalMemory() ) ) ),
                Double.parseDouble( format.format(   bytesToMegabytes( Runtime.getRuntime().totalMemory() + - Runtime.getRuntime().freeMemory() ) ) ),
                Double.parseDouble( format.format(  bytesToMegabytes( Runtime.getRuntime().totalMemory() ) ) )
        );
    }






    private double bytesToMegabytes(long bytes){
        return (double) (bytes / 1048576);
    }
    private double bytesToGigaBytes(long bytes){return (double) (bytes / 1073741824);}

}

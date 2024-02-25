package com.example.vindecoder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecoderServiceTest {

    @Test
    public void decodeSkodaVin() {
        //given
        DecoderService decoderService = new DecoderService();
        //when
        var result = decoderService.decode("TMBNB73T9A9046695");
        //then
        assertEquals("Škoda", result.getManufacturer());
        assertEquals("Europe", result.getRegion());
        assertEquals("CZ", result.getCountry());
        assertEquals("2010", result.getModelYear());
    }

    @Test
    public void decodeMercedesVin() {
        //given
        DecoderService decoderService = new DecoderService();
        //when
        var result = decoderService.decode("WDB2110061A581395");
        //then
        assertEquals("Mercedes-Benz", result.getManufacturer());
        assertEquals("Europe", result.getRegion());
        assertEquals("DE", result.getCountry());
        assertEquals("2001", result.getModelYear());
    }

    @Test
    public void decodeRenaultVin() {
        //given
        DecoderService decoderService = new DecoderService();
        //when
        var result = decoderService.decode("VF1BZ1M0641814955");
        //then
        assertEquals("Renault", result.getManufacturer());
        assertEquals("Europe", result.getRegion());
        assertEquals("FR", result.getCountry());
        assertEquals("2004", result.getModelYear());
    }

    @Test
    public void decodeIsuzuVin() {
        //given
        DecoderService decoderService = new DecoderService();
        //when
        var result = decoderService.decode("MPATFS87JPT026574");
        //then
        assertEquals("Isuzu", result.getManufacturer());
        assertEquals("Asia", result.getRegion());
        assertEquals("TH", result.getCountry());
        assertEquals("2023", result.getModelYear());
    }

     @Test
    public void decodeToyotaVin() {
        //given
        DecoderService decoderService = new DecoderService();
        //when
        var result = decoderService.decode("JTEHG20V406056490");
        //then
        assertEquals("Toyota", result.getManufacturer());
        assertEquals("Asia", result.getRegion());
        assertEquals("JP", result.getCountry());
        assertEquals("2000", result.getModelYear());
    }
}
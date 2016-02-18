package com.perpustakaan.markaz.syariah.controller;

import com.perpustakaan.markaz.syariah.domain.Tulisan;
import com.perpustakaan.markaz.syariah.service.TulisanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rizki on 27/06/15.
 */

@RestController
@RequestMapping(value = "/api")
public class TulisanRestController {

    @Autowired
    private TulisanService tulisanService;

    @RequestMapping(value = "/tulisan", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Tulisan> getTulisans(){
        return tulisanService.getTulisans();
    }

    @RequestMapping(value = "/tulisan/publish", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Tulisan getTulisanPublish(){
        return tulisanService.getTulisanPublish();
    }

    @RequestMapping(value = "/tulisan", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> updateTulisan(@RequestBody Tulisan tulisan){

        tulisanService.update(tulisan);

        Map<String, Object> objectsMap = new HashMap<>();
        objectsMap.put("success", Boolean.TRUE);
        objectsMap.put("Info", "Data di edit");

        return objectsMap;
    }

    @RequestMapping(value = "/tulisan/{idTulisan}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> deleteTulisan(@PathVariable("idTulisan")String idTulisan){

        tulisanService.delete(tulisanService.getTulisan(idTulisan));

        Map<String, Object> objectsMap = new HashMap<>();
        objectsMap.put("success", Boolean.TRUE);
        objectsMap.put("Info", "Data di hapus");

        return objectsMap;
    }

}

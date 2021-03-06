package br.ufsc.smartmedic.persistencia;

import br.ufsc.smartmedic.model.Consulta;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapeadorConsulta {
    private HashMap<Long, Consulta> cacheConsultas = new HashMap<>();
    private final String FILENAME = "consultasSmartMedic.cons";

    public MapeadorConsulta() {
        load();
    }

    public Consulta get(Long id) {
        return cacheConsultas.get(id);
    }

    public void put(Consulta consulta) {
        cacheConsultas.put(consulta.getId(), consulta);
        persist();
    }

    public List<Consulta> getList() {
        return new ArrayList<>(cacheConsultas.values());
    }

    public void persist() {
        try {
            FileOutputStream fileOutput = new FileOutputStream(FILENAME);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(cacheConsultas);
            objectOutput.flush();
            fileOutput.flush();
            objectOutput.close();
            fileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            FileInputStream fileInput = new FileInputStream(FILENAME);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            this.cacheConsultas = (HashMap<Long, Consulta>) objectInput.readObject();
            objectInput.close();
            fileInput.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            persist();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(Consulta consulta) {
        cacheConsultas.remove(consulta.getId());
    }

}

package br.ufsc.smartmedic.model.formularios;

import br.ufsc.smartmedic.model.Medico;
import br.ufsc.smartmedic.model.PrescricaoMedicamento;
import br.ufsc.smartmedic.model.UnidadeAtendimento;

import java.util.List;

public class FormularioRespostaChamado {
    private long id;
    private String diagnostico;
    private List<PrescricaoMedicamento> prescricaoMedicamentos;
    private boolean encaminhamento;
    private UnidadeAtendimento unidadeDeEncaminhamento;
    private Medico medicoEncaminhamento;

    public FormularioRespostaChamado() {

    }

    public FormularioRespostaChamado(long id, String diagnostico, boolean encaminhamento, UnidadeAtendimento unidadeDeEncaminhamento) {
        this.id = id;
        this.diagnostico = diagnostico;
        this.encaminhamento = encaminhamento;
        this.unidadeDeEncaminhamento = unidadeDeEncaminhamento;
    }

    public String getDiagnostico() {
        return this.diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setPrescricaoMedicamentos(List<PrescricaoMedicamento> prescricaoMedicamentos) {
        this.prescricaoMedicamentos = prescricaoMedicamentos;
    }

    public UnidadeAtendimento getUnidadeDeEncaminhamento() {
        return this.unidadeDeEncaminhamento;
    }

    public void setUnidadeDeEncaminhamento(UnidadeAtendimento unidadeDeEncaminhamento) {
        this.unidadeDeEncaminhamento = unidadeDeEncaminhamento;
    }

    public Medico getMedicoEncaminhamento() { return this.medicoEncaminhamento; }

    public void setMedicoEncaminhamento(Medico medicoEncaminhamento) {
        this.medicoEncaminhamento = medicoEncaminhamento;
    }

    public boolean getEncaminhamento() {
        return this.encaminhamento;
    }

    public void setEncaminhamento(boolean encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    public List<PrescricaoMedicamento> getPrescricaoMedicamentos() {
        return prescricaoMedicamentos;
    }

    public boolean isEncaminhamento() {
        return encaminhamento;
    }
}

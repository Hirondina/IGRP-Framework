/*-------------------------*/

/*Create View*/

package nosi.webapps.igrp.pages.importarquivo;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;

public class ImportArquivoView extends View {
	
	
	public Field sectionheader_1_text;
	public Field importar_aplicacao;
	public Field importar_pagina;
	public Field arquivo_aplicacao;
	public Field list_aplicacao;
	public Field arquivo_pagina;
	public IGRPSectionHeader sectionheader_1;
	public IGRPTabContent tabcontent_1;
	public IGRPForm form_2;
	public IGRPForm form_1;

	public IGRPButton btn_btm_import_aplicacao;
	public IGRPButton btn_btm_importar_page;
	public ImportArquivoView(ImportArquivo model){
		this.setPageTitle("Import Arquivo");
			
		sectionheader_1 = new IGRPSectionHeader("sectionheader_1","");
		tabcontent_1 = new IGRPTabContent("tabcontent_1","");
		form_2 = new IGRPForm("form_2","");
		form_1 = new IGRPForm("form_1","");
		sectionheader_1_text = new TextField(model,"sectionheader_1_text");
		sectionheader_1_text.setLabel("");
		
		sectionheader_1_text.setValue("Import Arquivos Jar/Zip (P�ginas/Aplica��es)");
		sectionheader_1_text.propertie().add("type","text").add("name","p_sectionheader_1_text").add("persist","true").add("maxlength","4000");
		importar_aplicacao = new TextField(model,"importar_aplicacao");
		importar_aplicacao.setLabel("Importar Aplica��o");
		
		importar_aplicacao.propertie().add("name","p_importar_aplicacao").add("type","button").add("target_fields","").add("closerefresh","false").add("iconColor","#333").add("iconClass","").add("img","fa-cloud-download").add("maxlength","50");
		importar_pagina = new TextField(model,"importar_pagina");
		importar_pagina.setLabel("Importar P�gina");
		
		importar_pagina.propertie().add("name","p_importar_pagina").add("type","button").add("target_fields","").add("closerefresh","false").add("iconColor","#333").add("iconClass","").add("img","fa-cloud-download").add("maxlength","50");
		arquivo_aplicacao = new FileField(model,"arquivo_aplicacao");
		arquivo_aplicacao.setLabel("Aplica��o");
		
		arquivo_aplicacao.propertie().add("name","p_arquivo_aplicacao").add("type","file").add("accept","").add("targetrend","").add("multiple","false").add("rendvalue","false").add("maxlength","30").add("required","true").add("disabled","false").add("right","false").add("class","primary");
		list_aplicacao = new ListField(model,"list_aplicacao");
		list_aplicacao.setLabel("Aplica��o");
		
		list_aplicacao.propertie().add("name","p_list_aplicacao").add("type","select").add("multiple","false").add("domain","").add("maxlength","30").add("required","true").add("change","false").add("disabled","false").add("right","false");
		arquivo_pagina = new FileField(model,"arquivo_pagina");
		arquivo_pagina.setLabel("P�gina");
		
		arquivo_pagina.propertie().add("name","p_arquivo_pagina").add("type","file").add("accept","").add("targetrend","").add("multiple","false").add("rendvalue","false").add("maxlength","30").add("required","true").add("disabled","false").add("right","false").add("class","primary");

		btn_btm_import_aplicacao = new IGRPButton("Import","igrp","ImportArquivo","btm_import_aplicacao","submit_form","success|fa-download","","");
		btn_btm_import_aplicacao.propertie.add("type","form").add("code","").add("class","success").add("rel","btm_import_aplicacao");
		btn_btm_importar_page = new IGRPButton("Import","igrp","ImportArquivo","btm_importar_page","submit_form","success|fa-download","","");
		btn_btm_importar_page.propertie.add("type","form").add("code","").add("class","success").add("rel","btm_importar_page");
		
	}
		
	@Override
	public void render(){
		
		sectionheader_1.addField(sectionheader_1_text);

		tabcontent_1.addField(importar_aplicacao);
		tabcontent_1.addField(importar_pagina);

		form_2.addField(arquivo_aplicacao);

		form_1.addField(list_aplicacao);
		form_1.addField(arquivo_pagina);

		form_2.addButton(btn_btm_import_aplicacao);
		form_1.addButton(btn_btm_importar_page);
		this.addToPage(sectionheader_1);
		this.addToPage(tabcontent_1);
		this.addToPage(form_2);
		this.addToPage(form_1);
	}
}
/*-------------------------*/
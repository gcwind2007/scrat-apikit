package org.forkjoin.scrat.apikit.tool.generator;

import org.forkjoin.scrat.apikit.tool.info.ApiInfo;
import org.forkjoin.scrat.apikit.tool.wrapper.JavaClientApiWrapper;

import java.io.File;

/**
 *
 */
public class JavaClientGenerator extends JavaGenerator {
    private boolean isAnnotations = false;


    public JavaClientGenerator() {
    }


    @Override
    public void generateApi(ApiInfo apiInfo) throws Exception {
        JavaClientApiWrapper utils = new JavaClientApiWrapper(
                context, apiInfo, rootPackage, apiNameMaper
        );
        utils.setAnnotations(isAnnotations);
        File file = getFileName(utils);
        utils.init();
        executeModule(
                utils,
                "/org/forkjoin/scrat/apikit/tool/generator/ReactiveApiItem.httl",
                file
        );
    }


    @Override
    public void generateTool() throws Exception {
    }


    public boolean isAnnotations() {
        return isAnnotations;
    }

    public void setAnnotations(boolean annotations) {
        isAnnotations = annotations;
    }

    public NameMaper getApiNameMaper() {
        return apiNameMaper;
    }

    public void setApiNameMaper(NameMaper apiNameMaper) {
        this.apiNameMaper = apiNameMaper;
    }

}

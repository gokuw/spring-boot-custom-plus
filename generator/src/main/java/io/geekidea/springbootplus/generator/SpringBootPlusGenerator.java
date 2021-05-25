/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.geekidea.springbootplus.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import io.geekidea.springbootplus.generator.config.GeneratorStrategy;
import io.geekidea.springbootplus.generator.constant.GeneratorConstant;
import io.geekidea.springbootplus.generator.properties.GeneratorProperties;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;

import static io.geekidea.springbootplus.generator.constant.GeneratorConstant.MAPPER_XML_TEMPLATE_PATH;

/**
 * spring-boot-plus代码生成器入口类
 *
 * @author geekidea
 * @date 2019-10-22
 **/
@Component
public class SpringBootPlusGenerator {

    /**
     * 生成代码
     * @param args
     */
    public static void main(String[] args) {
        GeneratorProperties generatorProperties = new GeneratorProperties();
//TODO 自动生成导包依赖
// 字段类型 数据库设计为numeric java对应为double类型
        //service 和 mapper 和ctroller 位置错误

        // 设置基本信息
        generatorProperties
                .setMavenModuleName("example")
                .setParentPackage("com.zz.project")
                .setAuthor("wjy")
                .setFileOverride(true);
        // 设置表信息 可以多表
        generatorProperties
                .addTable("zz_likes","sid");
                //.addTable("","");
        // 设置表前缀  去除前缀
         generatorProperties.setTablePrefix(Arrays.asList("zz_"));

        // 数据源配置
        generatorProperties.getDataSourceConfig()
                .setDbType(DbType.POSTGRE_SQL)
                .setUsername("postgres")
                .setPassword("zzsoft")
                .setDriverName("org.postgresql.Driver")
               .setSchemaName("innovation_platform")
               .setUrl("jdbc:postgresql://192.168.16.48:5432/postgres?searchpath=innovation_platform&stringtype=unspecified&currentSchema=innovation_platform");

        // 生成配置
        generatorProperties.getGeneratorConfig()
                .setGeneratorStrategy(GeneratorStrategy.ALL)
                .setGeneratorEntity(true)
                .setGeneratorController(true)
                .setGeneratorService(true)
                .setGeneratorServiceImpl(true)
                .setGeneratorMapper(true)
                .setGeneratorMapperXml(true)
                .setGeneratorPageParam(true)
                .setGeneratorQueryVo(false)
                .setRequiresPermissions(false)
                .setPageListOrder(true)
                .setParamValidation(false)
                .setSwaggerTags(true)
                .setOperationLog(true);

        // 全局配置
        generatorProperties.getMybatisPlusGeneratorConfig().getGlobalConfig()
                .setOpen(true)
                .setSwagger2(true)
                .setIdType(IdType.AUTO)
                .setDateType(DateType.ONLY_DATE)
                .setBaseColumnList(true);

        // 策略配置
        generatorProperties.getMybatisPlusGeneratorConfig().getStrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true)
                .setVersionFieldName(GeneratorConstant.VERSION)
                .setLogicDeleteFieldName(GeneratorConstant.DELETED)
                .setSuperMapperClass("com.zz.common.base.BaseMapper")
                .setSuperServiceClass("com.zz.common.base.IBaseService")
                .setSuperServiceImplClass("com.zz.common.base.IBaseService")
                .setSuperEntityClass("com.zz.common.base.BaseEntity")
                .setSuperEntityColumns("sid","tzzd","scbj","pxbj","djr","djsj","gxr","gxsj","bz");

        // 生成代码
        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.generator(generatorProperties);

    }


}

package org.elac;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.baomidou.mybatisplus.generator.query.SQLQuery;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 *
 * @description: MysqlGenerator
 * </p>
 * @author: David
 * @create: 2022-11-16 02:02
 */
public class H2CodeGeneratorTest {

    /**
     * Data Source Configuration
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder(
            "jdbc:h2:/Users/mac/Documents/Dev/workspace/conscious-program/api/src/main/resources/elac;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;CASE_INSENSITIVE_IDENTIFIERS=TRUE;MODE=MySQL",
            "sa", "P@ssw0rd")
//            .databaseQueryClass(SQLQuery.class)
            .build();

    public static void main(String[] args) {
        //Multiple tables use comma to separate
        final String tables = "T_USERS";
        final String author = "David";
        final String parentModuleName = "";
        final String moduleName = "api";
        final String packageName = "org.elac";
        final String yes = "y";
        //Windows
        //final String outputDir = System.getProperty("user.dir") + "\\" + parentModuleName + "\\" + moduleName + "\\src\\main\\java";
        //final String outputXmlDir = System.getProperty("user.dir") + "\\" + moduleName + parentModuleName + "\\" + "\\src\\main\\resources\\mapper";
        //Mac
        final String outputDir = System.getProperty("user.dir") + "/" + parentModuleName + "/" + moduleName + "/src/main/java";
        final String outputXmlDir =
                System.getProperty("user.dir") + "/" + parentModuleName + "/" + moduleName + "/src/main/resources/mapper";
        Scanner input = new Scanner(System.in);
        System.out.print(
                "Will generate code for the following tables: " + tables + " in module: " +
                        parentModuleName + "/" + moduleName + ", continue? (y/n): ");
        String answer = input.next();
        if (!yes.equalsIgnoreCase(answer)) {
            return;
        }

        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        // Global Configuration
        generator.global(new GlobalConfig.Builder().author(author)
                .outputDir(outputDir)
                .commentDate("yyyy-MM-dd HH:mm:ss").build());

        // Package Configuration
        generator.packageInfo(new PackageConfig.Builder().
                parent(packageName)
                .entity("entity")
                .mapper("mapper")
                .xml("mapper.xml")
                .service("service")
                .serviceImpl("service.impl")
                .pathInfo(Collections.singletonMap(OutputFile.xml, outputXmlDir)).build());
        // Strategy Configuration
        generator.strategy(new StrategyConfig.Builder().addInclude(
                        getTables(tables))
                .addTablePrefix("T_", "tbl")
                .enableCapitalMode()
                .entityBuilder().enableLombok()
                .enableTableFieldAnnotation()
                .formatFileName("%sEntity")
                .logicDeleteColumnName("delete_flag")
                .logicDeletePropertyName("delete")
                .addTableFills(
                        new Column("create_time", FieldFill.INSERT),
                        new Property("update_time", FieldFill.INSERT_UPDATE)
                ).idType(IdType.AUTO)
                .serviceBuilder()
                .formatServiceFileName("I%sService")
                .formatServiceImplFileName("%sServiceImpl")
                .mapperBuilder()
                .superClass(BaseMapper.class)
                .enableBaseResultMap()
                .enableBaseColumnList()
                .formatMapperFileName("%sMapper")
                .formatXmlFileName("%sMapper")
//                        .enableFileOverride()
                .build()).execute();
    }

    // Handle all case
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
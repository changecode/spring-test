package com.learning;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;

/**
 *  create luence main class
 *
 */
public class App
{
    public static void main( String[] args ) throws Exception {
        Article article = new Article(1,"Lucene全文检索框架","Lucene如果信息检索系统在用户发出了检索请求后再去网上找答案","luence");

        //分词器
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LATEST, analyzer);
        IndexWriter indexWriter = new IndexWriter(createLuceneIndex("./indexDir/"), indexWriterConfig);
        indexWriter.addDocument(objectToDoc(article));
        indexWriter.close();
    }

    /**建立索引库
     * @param pathname
     * @return
     * @throws Exception
     */
    private static Directory createLuceneIndex(String pathname) throws Exception{
        return  FSDirectory.open(new File(pathname));
    }

    /**
     * 把Article转换为Doucement对象
     * 只有TextField的值会进行分词，其他类型的Field都不会进行分词。
     * 不进行 分词的后果是，用户检索的关键字必须与这个字段的内容完全匹配上，才返回这条记录
     * @param article
     * @return
     */
    private static Document objectToDoc(Article article) {
        Document doc = new Document();
        doc.add(new LongField("id", article.getId(), Field.Store.YES));
        doc.add(new StringField("author", article.getAuthor(), Field.Store.YES));
        doc.add(new TextField("title", article.getTitle(), Field.Store.YES));
        //Store.YES和Store.NO的作用是，如果选择了YES，在建立索引后，
        // 会把这个字段的原始值也保存在数据库中，而NO则是不保存
        doc.add(new TextField("content", article.getContent(), Field.Store.NO));
        return doc;
    }
}

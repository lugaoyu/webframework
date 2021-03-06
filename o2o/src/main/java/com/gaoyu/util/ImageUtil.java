package com.gaoyu.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;


/**
 * 
 * ClassName: ImageUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年6月23日 下午2:38:49 <br/>
 *
 * @author gaoyu
 * @version
 * @since JDK 1.7
 */
public class ImageUtil
{
        private static String basePath = Thread.currentThread()
                        .getContextClassLoader()
                        .getResource("")
                        .getPath();
        
        private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        
        private static final Random r = new Random();
        
        /**
         * 处理缩略图，并返回新生成图片的相对值路径
         * 
         * @param thumbnail
         * @param targetAddr
         * @return
         */
        public static String generateThumbnail(File thumbnail, String targetAddr)
        {
                String realFileName = getRandomFileName();
                String extension = getFileExtension(thumbnail);
                makeDirPath(targetAddr);
                String relativeAddr = targetAddr + realFileName + extension;
                File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
                try
                {
                        Thumbnails.of(thumbnail)
                                        .size(200, 200)
                                        .watermark(Positions.BOTTOM_RIGHT,
                                                        ImageIO.read(new File(
                                                                        basePath
                                                                                        + "watermark.jpg")),
                                                        0.5f)
                                        .outputQuality(0.8f)
                                        .toFile(dest);
                }
                catch (IOException e)
                {
                        throw new RuntimeException("创建缩略图失败：" + e.toString());
                }
                return relativeAddr;
        }
        
        /**
         * 创建目标路径所涉及到的目录，即/home/work/o2o/xxx.jpg, 那么 home work o2o 这三个文件夹都得自动创建
         * 
         * @param targetAddr
         */
        private static void makeDirPath(String targetAddr)
        {
                // TODO Auto-generated method stub
                String realFileParentPath =
                        PathUtil.getImgBasePath() + targetAddr;
                File dirPath = new File(realFileParentPath);
                if (!dirPath.exists())
                {
                        dirPath.mkdirs();
                }
        }
        
        /**
         * 生成随机文件名，当前年月日小时分钟秒+五位随机数
         */
        public static String getRandomFileName()
        {
                // 获取随机的五位数
                int rannum = r.nextInt(89999) + 10000;
                String nowTimeStr = sDateFormat.format(new Date());
                return nowTimeStr + rannum;
        }
        
        /**
         * 获取输入文件流的扩展名
         * 
         * @param args
         * @throws IOException
         */
        private static String getFileExtension(File thumbnail)
        {
                String originalFileName = thumbnail.getName();
                return originalFileName.substring(originalFileName.lastIndexOf("."));
        }
        
        public static void main(String[] args)
                throws IOException
        {
                
                Thumbnails.of(new File("/Users/mac/Downloads/luoto.png"))
                                .size(200, 200)
                                .watermark(Positions.BOTTOM_RIGHT,
                                                ImageIO.read(new File(basePath
                                                                + "/jingyu.png")),
                                                0.25f)
                                .outputQuality(0.8f)
                                .toFile("/Users/mac/Downloads/luotonew.png");
        }
}

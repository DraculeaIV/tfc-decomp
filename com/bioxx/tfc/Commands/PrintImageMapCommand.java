/*     */ package com.bioxx.tfc.Commands;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import javax.imageio.ImageIO;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PrintImageMapCommand
/*     */   extends CommandBase
/*     */ {
/*     */   public String func_71517_b() {
/*  30 */     return "printimage";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender sender, String[] params) {
/*  36 */     EntityPlayerMP player = func_71521_c(sender);
/*     */     
/*  38 */     if (!TFCOptions.enableDebugMode) {
/*     */       
/*  40 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Debug Mode Required"));
/*     */       
/*     */       return;
/*     */     } 
/*  44 */     MinecraftServer server = MinecraftServer.func_71276_C();
/*  45 */     WorldServer world = server.func_71218_a((player.func_130014_f_()).field_73011_w.field_76574_g);
/*  46 */     if (params.length >= 2) {
/*     */       
/*  48 */       String name = params[1];
/*  49 */       if (params[0].equals("biome")) {
/*     */         
/*  51 */         int size = (params.length >= 3) ? Integer.parseInt(params[2]) : 512;
/*  52 */         int skipSize = (params.length >= 4) ? Integer.parseInt(params[3]) : 1;
/*  53 */         drawBiomeImage((int)Math.floor(player.field_70165_t), (int)Math.floor(player.field_70161_v), size, (World)world, name, skipSize);
/*     */       }
/*  55 */       else if (params[0].equals("temp")) {
/*     */         
/*  57 */         int size = (params.length >= 3) ? Integer.parseInt(params[2]) : 512;
/*  58 */         int skipSize = (params.length >= 4) ? Integer.parseInt(params[3]) : 1;
/*  59 */         drawTempImage((int)Math.floor(player.field_70165_t), (int)Math.floor(player.field_70161_v), size, (World)world, name, skipSize);
/*     */       }
/*  61 */       else if (params[0].equals("drainage")) {
/*     */         
/*  63 */         int size = (params.length >= 3) ? Integer.parseInt(params[2]) : 512;
/*  64 */         int skipSize = (params.length >= 4) ? Integer.parseInt(params[3]) : 1;
/*  65 */         drawDrainageImage((int)Math.floor(player.field_70165_t), (int)Math.floor(player.field_70161_v), size, (World)world, name, skipSize);
/*     */       }
/*  67 */       else if (params[0].equals("ph")) {
/*     */         
/*  69 */         int size = (params.length >= 3) ? Integer.parseInt(params[2]) : 512;
/*  70 */         int skipSize = (params.length >= 4) ? Integer.parseInt(params[3]) : 1;
/*  71 */         drawPhImage((int)Math.floor(player.field_70165_t), (int)Math.floor(player.field_70161_v), size, (World)world, name, skipSize);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawPhImage(int xCoord, int zCoord, int size, World world, String name, int skipSize) {
/*     */     try {
/*  79 */       File outFile = new File(name + ".bmp");
/*  80 */       BufferedImage outBitmap = new BufferedImage(size, size, 1);
/*  81 */       Graphics2D graphics = (Graphics2D)outBitmap.getGraphics();
/*  82 */       graphics.clearRect(0, 0, size, size);
/*  83 */       TerraFirmaCraft.LOG.info(name + ".bmp");
/*  84 */       float perc = 0.1F;
/*  85 */       int sizeHalf = size / 2;
/*  86 */       float count = 0.0F;
/*  87 */       for (int x = -sizeHalf; x < sizeHalf; x++) {
/*     */         
/*  89 */         for (int z = -sizeHalf; z < sizeHalf; z++) {
/*     */           
/*  91 */           count++;
/*  92 */           int ph = (TFC_Climate.getCacheManager(world).getDrainageLayerAt(xCoord + x * skipSize, zCoord + z * skipSize)).data1;
/*  93 */           int g = ph * 50;
/*  94 */           graphics.setColor(Color.getColor("", g << 8));
/*  95 */           graphics.drawRect(x + sizeHalf, z + sizeHalf, 1, 1);
/*  96 */           if (count / (size * size) > perc) {
/*     */             
/*  98 */             TerraFirmaCraft.LOG.info((int)(perc * 100.0F) + "%");
/*  99 */             perc += 0.1F;
/*     */           } 
/*     */         } 
/*     */       } 
/* 103 */       TerraFirmaCraft.LOG.info(name + ".bmp Done!");
/* 104 */       ImageIO.write(outBitmap, "BMP", outFile);
/*     */     }
/* 106 */     catch (Exception e) {
/*     */       
/* 108 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawDrainageImage(int xCoord, int zCoord, int size, World world, String name, int skipSize) {
/*     */     try {
/* 115 */       File outFile = new File(name + ".bmp");
/* 116 */       BufferedImage outBitmap = new BufferedImage(size, size, 1);
/* 117 */       Graphics2D graphics = (Graphics2D)outBitmap.getGraphics();
/* 118 */       graphics.clearRect(0, 0, size, size);
/* 119 */       TerraFirmaCraft.LOG.info(name + ".bmp");
/* 120 */       float perc = 0.1F;
/* 121 */       int sizeHalf = size / 2;
/* 122 */       float count = 0.0F;
/* 123 */       for (int x = -sizeHalf; x < sizeHalf; x++) {
/*     */         
/* 125 */         for (int z = -sizeHalf; z < sizeHalf; z++) {
/*     */           
/* 127 */           count++;
/* 128 */           DataLayer dl = TFC_Climate.getCacheManager(world).getDrainageLayerAt(xCoord + x * skipSize, zCoord + z * skipSize);
/* 129 */           int drainage = dl.data1;
/* 130 */           int r = drainage * 42 / 2;
/* 131 */           int g = drainage * 42 / 4;
/* 132 */           graphics.setColor(Color.getColor("", (r << 16) + (g << 8)));
/* 133 */           graphics.drawRect(x + sizeHalf, z + sizeHalf, 1, 1);
/* 134 */           if (count / (size * size) > perc) {
/*     */             
/* 136 */             TerraFirmaCraft.LOG.info((int)(perc * 100.0F) + "%");
/* 137 */             perc += 0.1F;
/*     */           } 
/*     */         } 
/*     */       } 
/* 141 */       TerraFirmaCraft.LOG.info(name + ".bmp Done!");
/* 142 */       ImageIO.write(outBitmap, "BMP", outFile);
/*     */     }
/* 144 */     catch (Exception e) {
/*     */       
/* 146 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawTempImage(int xCoord, int zCoord, int size, World world, String name, int skipSize) {
/*     */     try {
/* 153 */       File outFile = new File(name + ".bmp");
/* 154 */       BufferedImage outBitmap = new BufferedImage(size, size, 1);
/* 155 */       Graphics2D graphics = (Graphics2D)outBitmap.getGraphics();
/* 156 */       graphics.clearRect(0, 0, size, size);
/* 157 */       TerraFirmaCraft.LOG.info(name + ".bmp");
/* 158 */       float perc = 0.1F;
/* 159 */       int sizeHalf = size / 2;
/* 160 */       float count = 0.0F;
/* 161 */       for (int x = -sizeHalf; x < sizeHalf; x++) {
/*     */         
/* 163 */         for (int z = -sizeHalf; z < sizeHalf; z++) {
/*     */           
/* 165 */           count++;
/* 166 */           int temp = (int)(255.0F * TFC_Climate.getBioTemperature(world, xCoord + x * skipSize, zCoord + z * skipSize) / 50.0F);
/* 167 */           graphics.setColor(Color.getColor("", (temp << 16) + (temp << 8) + temp));
/* 168 */           graphics.drawRect(x + sizeHalf, z + sizeHalf, 1, 1);
/* 169 */           if (count / (size * size) > perc) {
/*     */             
/* 171 */             TerraFirmaCraft.LOG.info((int)(perc * 100.0F) + "%");
/* 172 */             perc += 0.1F;
/*     */           } 
/*     */         } 
/*     */       } 
/* 176 */       TerraFirmaCraft.LOG.info(name + ".bmp Done!");
/* 177 */       ImageIO.write(outBitmap, "BMP", outFile);
/*     */     }
/* 179 */     catch (Exception e) {
/*     */       
/* 181 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawBiomeImage(int xCoord, int zCoord, int size, World world, String name, int skipSize) {
/*     */     try {
/* 188 */       File outFile = new File(name + ".bmp");
/* 189 */       BufferedImage outBitmap = new BufferedImage(size, size, 1);
/* 190 */       Graphics2D graphics = (Graphics2D)outBitmap.getGraphics();
/* 191 */       graphics.clearRect(0, 0, size, size);
/* 192 */       TerraFirmaCraft.LOG.info(name + ".bmp");
/* 193 */       float perc = 0.1F;
/* 194 */       float count = 0.0F;
/* 195 */       for (int x = -size / 2; x < size / 2; x++) {
/*     */         
/* 197 */         for (int z = -size / 2; z < size / 2; z++) {
/*     */           
/* 199 */           count++;
/* 200 */           graphics.setColor(Color.getColor("", ((TFCBiome)world.func_72959_q().func_76935_a(x * skipSize + xCoord, z * skipSize + zCoord)).getBiomeColor()));
/* 201 */           graphics.drawRect(x + size / 2, z + size / 2, 1, 1);
/* 202 */           if (count / (size * size) > perc) {
/*     */             
/* 204 */             TerraFirmaCraft.LOG.info((int)(perc * 100.0F) + "%");
/* 205 */             perc += 0.1F;
/*     */           } 
/*     */         } 
/*     */       } 
/* 209 */       TerraFirmaCraft.LOG.info(name + ".bmp Done!");
/* 210 */       ImageIO.write(outBitmap, "BMP", outFile);
/*     */     }
/* 212 */     catch (Exception e) {
/*     */       
/* 214 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/* 221 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\PrintImageMapCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
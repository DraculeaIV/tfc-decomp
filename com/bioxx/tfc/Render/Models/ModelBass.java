/*     */ package com.bioxx.tfc.Render.Models;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelBass
/*     */   extends ModelBase
/*     */ {
/*     */   private ModelRenderer head;
/*     */   private ModelRenderer mouth;
/*     */   private ModelRenderer gils;
/*     */   private ModelRenderer neck;
/*     */   private ModelRenderer body;
/*     */   private ModelRenderer back;
/*     */   private ModelRenderer rear;
/*     */   private ModelRenderer tail;
/*     */   private ModelRenderer tailEnd;
/*     */   private ModelRenderer tailFin;
/*     */   private ModelRenderer dorsalFin;
/*     */   private ModelRenderer analFin;
/*     */   private ModelRenderer pelvicFinBox;
/*     */   private ModelRenderer pectoralFinBox;
/*     */   private long n;
/*     */   private float rotateMouth;
/*     */   private float rotateSwim;
/*     */   
/*     */   public ModelBass() {
/*  38 */     this.field_78090_t = 128;
/*  39 */     this.field_78089_u = 64;
/*     */     
/*  41 */     this.head = new ModelRenderer(this, 0, 0);
/*  42 */     this.head.func_78789_a(-2.5F, 0.0F, 0.0F, 5, 5, 4);
/*  43 */     this.head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.head.func_78787_b(128, 64);
/*  45 */     this.head.field_78809_i = true;
/*  46 */     setRotation(this.head, 0.5235988F, 0.0F, 0.0F);
/*  47 */     this.mouth = new ModelRenderer(this, 24, 0);
/*  48 */     this.mouth.func_78789_a(-2.0F, -1.0F, -5.0F, 4, 1, 6);
/*  49 */     this.mouth.func_78793_a(0.0F, 4.0F, 4.0F);
/*  50 */     this.mouth.func_78787_b(128, 64);
/*  51 */     this.mouth.field_78809_i = true;
/*  52 */     setRotation(this.mouth, -0.2617994F, 0.0F, 0.0F);
/*  53 */     this.gils = new ModelRenderer(this, 64, 0);
/*  54 */     this.gils.func_78789_a(-3.0F, 2.0F, 2.0F, 6, 4, 5);
/*  55 */     this.gils.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.gils.func_78787_b(128, 64);
/*  57 */     this.gils.field_78809_i = true;
/*  58 */     setRotation(this.gils, 0.5235988F, 0.0F, 0.0F);
/*  59 */     this.neck = new ModelRenderer(this, 44, 0);
/*  60 */     this.neck.func_78789_a(-2.0F, -1.2F, 3.5F, 4, 2, 6);
/*  61 */     this.neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.neck.func_78787_b(128, 64);
/*  63 */     this.neck.field_78809_i = true;
/*  64 */     setRotation(this.neck, 0.1745329F, 0.0F, 0.0F);
/*  65 */     this.body = new ModelRenderer(this, 0, 17);
/*  66 */     this.body.func_78789_a(-2.5F, -1.5F, 5.0F, 5, 6, 10);
/*  67 */     this.body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.body.func_78787_b(128, 64);
/*  69 */     this.body.field_78809_i = true;
/*  70 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  71 */     this.back = new ModelRenderer(this, 30, 17);
/*  72 */     this.back.func_78789_a(-2.0F, -3.3F, 9.0F, 4, 3, 7);
/*  73 */     this.back.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.back.func_78787_b(128, 64);
/*  75 */     this.back.field_78809_i = true;
/*  76 */     setRotation(this.back, -0.0523599F, 0.0F, 0.0F);
/*  77 */     this.rear = new ModelRenderer(this, 0, 33);
/*  78 */     this.rear.func_78789_a(-2.0F, 5.4F, 12.9F, 4, 3, 4);
/*  79 */     this.rear.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     this.rear.func_78787_b(128, 64);
/*  81 */     this.rear.field_78809_i = true;
/*  82 */     setRotation(this.rear, 0.2792527F, 0.0F, 0.0F);
/*  83 */     this.tail = new ModelRenderer(this, 16, 33);
/*  84 */     this.tail.func_78789_a(-1.5F, -11.0F, 12.3F, 3, 4, 5);
/*  85 */     this.tail.func_78793_a(0.0F, 1.0F, 0.0F);
/*  86 */     this.tail.func_78787_b(128, 64);
/*  87 */     this.tail.field_78809_i = true;
/*  88 */     setRotation(this.tail, -0.5235988F, 0.0F, 0.0F);
/*  89 */     this.tailEnd = new ModelRenderer(this, 32, 33);
/*  90 */     this.tailEnd.func_78789_a(-1.0F, -0.5F, 0.0F, 2, 3, 5);
/*  91 */     this.tailEnd.func_78793_a(0.0F, 0.0F, 19.0F);
/*  92 */     this.tailEnd.func_78787_b(128, 64);
/*  93 */     this.tailEnd.field_78809_i = true;
/*  94 */     setRotation(this.tailEnd, 0.0F, 0.0F, 0.0F);
/*  95 */     this.tailFin = new ModelRenderer(this, 0, 51);
/*  96 */     this.tailFin.func_78789_a(0.0F, -2.5F, 0.0F, 0, 7, 6);
/*  97 */     this.tailFin.func_78793_a(0.0F, 0.0F, 4.0F);
/*  98 */     this.tailFin.func_78787_b(128, 64);
/*  99 */     this.tailFin.field_78809_i = true;
/* 100 */     setRotation(this.tailFin, 0.0F, 0.0F, 0.0F);
/* 101 */     this.tailEnd.func_78792_a(this.tailFin);
/* 102 */     this.dorsalFin = new ModelRenderer(this, 12, 47);
/* 103 */     this.dorsalFin.func_78789_a(0.0F, -8.5F, 8.0F, 0, 5, 12);
/* 104 */     this.dorsalFin.func_78793_a(0.0F, 0.0F, 0.0F);
/* 105 */     this.dorsalFin.func_78787_b(128, 64);
/* 106 */     this.dorsalFin.field_78809_i = true;
/* 107 */     setRotation(this.dorsalFin, -0.0872665F, 0.0F, 0.0F);
/* 108 */     this.analFin = new ModelRenderer(this, 36, 55);
/* 109 */     this.analFin.func_78789_a(0.0F, 10.0F, 12.0F, 0, 4, 5);
/* 110 */     this.analFin.func_78793_a(0.0F, 0.0F, 0.0F);
/* 111 */     this.analFin.func_78787_b(128, 64);
/* 112 */     this.analFin.field_78809_i = true;
/* 113 */     setRotation(this.analFin, 0.4363323F, 0.0F, 0.0F);
/* 114 */     this.pelvicFinBox = new ModelRenderer(this, 53, 33);
/* 115 */     this.pelvicFinBox.func_78789_a(-1.5F, -1.0F, 8.0F, 3, 2, 4);
/* 116 */     this.pelvicFinBox.func_78793_a(0.0F, 0.0F, 0.0F);
/* 117 */     this.pelvicFinBox.func_78787_b(128, 64);
/* 118 */     this.pelvicFinBox.field_78809_i = true;
/* 119 */     setRotation(this.pelvicFinBox, -0.5235988F, 0.0F, 0.0F);
/* 120 */     this.pectoralFinBox = new ModelRenderer(this, 67, 33);
/* 121 */     this.pectoralFinBox.func_78789_a(-3.0F, 4.4F, 6.7F, 6, 2, 4);
/* 122 */     this.pectoralFinBox.func_78793_a(0.0F, 0.0F, 0.0F);
/* 123 */     this.pectoralFinBox.func_78787_b(128, 64);
/* 124 */     this.pectoralFinBox.field_78809_i = true;
/* 125 */     setRotation(this.pectoralFinBox, 0.2617994F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 131 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 132 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 133 */     this.head.func_78785_a(f5);
/* 134 */     this.mouth.func_78785_a(f5);
/* 135 */     this.gils.func_78785_a(f5);
/* 136 */     this.neck.func_78785_a(f5);
/* 137 */     this.body.func_78785_a(f5);
/* 138 */     this.back.func_78785_a(f5);
/* 139 */     this.rear.func_78785_a(f5);
/* 140 */     this.tail.func_78785_a(f5);
/* 141 */     this.tailEnd.func_78785_a(f5);
/*     */     
/* 143 */     this.dorsalFin.func_78785_a(f5);
/* 144 */     this.analFin.func_78785_a(f5);
/* 145 */     this.pelvicFinBox.func_78785_a(f5);
/* 146 */     this.pectoralFinBox.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 151 */     model.field_78795_f = x;
/* 152 */     model.field_78796_g = y;
/* 153 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/* 159 */     super.func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 161 */     this.n = TFC_Time.getTotalTicks() % 30L;
/* 162 */     this.rotateMouth = (float)(this.n * (this.n - 30L)) * 0.0022F;
/* 163 */     this.rotateSwim = (float)(this.n * (this.n - 30L)) * -0.0044F;
/*     */     
/* 165 */     setRotation(this.mouth, -0.2617994F + -0.2617994F * this.rotateMouth, 0.0F, 0.0F);
/*     */     
/* 167 */     if (entity.func_70090_H() || entity.field_70160_al) {
/*     */       
/* 169 */       setRotation(this.tailEnd, 0.0F, -0.2617994F + 0.2617994F * this.rotateSwim * (entity.field_70160_al ? 4 : 2), 0.0F);
/* 170 */       setRotation(this.tailFin, 0.0F, -0.2617994F + 0.2617994F * this.rotateSwim * (entity.field_70160_al ? 4 : 2), 0.0F);
/*     */     }
/*     */     else {
/*     */       
/* 174 */       setRotation(this.tailEnd, 0.0F, 0.0F, 0.0F);
/* 175 */       setRotation(this.tailFin, 0.0F, 0.0F, 0.0F);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelBass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
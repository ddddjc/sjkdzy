<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="品牌名" prop="brandName">
        <el-input
          v-model="queryParams.brandName"
          placeholder="请输入品牌名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="品牌公司" prop="brandCompany">
        <el-input
          v-model="queryParams.brandCompany"
          placeholder="请输入品牌公司"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="品牌描述" prop="brandDescript">
        <el-input
          v-model="queryParams.brandDescript"
          placeholder="请输入品牌描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['database:brand:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['database:brand:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['database:brand:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['database:brand:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="brandList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="品牌id" align="center" prop="brandId" />
      <el-table-column label="品牌名" align="center" prop="brandName" />
      <el-table-column label="品牌公司" align="center" prop="brandCompany" />
      <el-table-column label="品牌描述" align="center" prop="brandDescript" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['database:brand:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['database:brand:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改品牌管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="品牌名" prop="brandName">
          <el-input v-model="form.brandName" placeholder="请输入品牌名" />
        </el-form-item>
        <el-form-item label="品牌公司" prop="brandCompany">
          <el-input v-model="form.brandCompany" placeholder="请输入品牌公司" />
        </el-form-item>
        <el-form-item label="品牌描述" prop="brandDescript">
          <el-input v-model="form.brandDescript" placeholder="请输入品牌描述" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-divider content-position="center">物品信息管理信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddProduct">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteProduct">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="productList" :row-class-name="rowProductIndex" @selection-change="handleProductSelectionChange" ref="product">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="商品名" prop="productName" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.productName" placeholder="请输入商品名" />
            </template>
          </el-table-column>
          <el-table-column label="商品采购价格" prop="productPurchasePrice" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.productPurchasePrice" placeholder="请输入商品采购价格" />
            </template>
          </el-table-column>
          <el-table-column label="商品售出价格" prop="productSalePrice" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.productSalePrice" placeholder="请输入商品售出价格" />
            </template>
          </el-table-column>
          <el-table-column label="商品描述" prop="productDescription" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.productDescription" placeholder="请输入商品描述" />
            </template>
          </el-table-column>
          <el-table-column label="状态" prop="status" width="150">
            <template slot-scope="scope">
              <el-select v-model="scope.row.status" placeholder="请选择状态">
                <el-option label="请选择字典生成" value="" />
              </el-select>
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listBrand, getBrand, delBrand, addBrand, updateBrand } from "@/api/database/brand";

export default {
  name: "Brand",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedProduct: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 品牌管理表格数据
      brandList: [],
      // 物品信息管理表格数据
      productList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        brandName: null,
        brandCompany: null,
        brandDescript: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        status: [
          { required: true, message: "状态不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询品牌管理列表 */
    getList() {
      this.loading = true;
      listBrand(this.queryParams).then(response => {
        this.brandList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        brandId: null,
        brandName: null,
        brandCompany: null,
        brandDescript: null,
        status: "0",
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.productList = [];
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.brandId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加品牌管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const brandId = row.brandId || this.ids
      getBrand(brandId).then(response => {
        this.form = response.data;
        this.productList = response.data.productList;
        this.open = true;
        this.title = "修改品牌管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.productList = this.productList;
          if (this.form.brandId != null) {
            updateBrand(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBrand(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const brandIds = row.brandId || this.ids;
      this.$modal.confirm('是否确认删除品牌管理编号为"' + brandIds + '"的数据项？').then(function() {
        return delBrand(brandIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
	/** 物品信息管理序号 */
    rowProductIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 物品信息管理添加按钮操作 */
    handleAddProduct() {
      let obj = {};
      obj.productName = "";
      obj.productPurchasePrice = "";
      obj.productSalePrice = "";
      obj.productDescription = "";
      obj.status = "";
      obj.remark = "";
      this.productList.push(obj);
    },
    /** 物品信息管理删除按钮操作 */
    handleDeleteProduct() {
      if (this.checkedProduct.length == 0) {
        this.$modal.msgError("请先选择要删除的物品信息管理数据");
      } else {
        const productList = this.productList;
        const checkedProduct = this.checkedProduct;
        this.productList = productList.filter(function(item) {
          return checkedProduct.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleProductSelectionChange(selection) {
      this.checkedProduct = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('database/brand/export', {
        ...this.queryParams
      }, `brand_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

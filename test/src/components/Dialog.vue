<template>
    
    <div>
         <el-button type="button"  @click="dialogFormVisible = true"> 注册</el-button>

        <el-dialog   :title="textMap[dialogStatus]"
           :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="username" :label-width="formLabelWidth">
          <el-input v-model="form.username" autocomplete="off" ></el-input>
        </el-form-item>
        <el-form-item label="password" :label-width="formLabelWidth">
          <el-input v-model="form.password" autocomplete="off"></el-input>
        </el-form-item>
         <el-form-item label="email" :label-width="formLabelWidth">
          <el-input v-model="form.email" autocomplete="off"></el-input>
        </el-form-item>
         <el-form-item label="address" :label-width="formLabelWidth">
          <el-input v-model="form.address" autocomplete="off"></el-input>
        </el-form-item>
          <el-form-item label="tel" :label-width="formLabelWidth">
          <el-input v-model="form.tel" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>

        <el-button type="primary"
                 
                   v-if="dialogStatus === 'add'"
                  @click="add">注册</el-button>

           <el-button type="primary"
                  v-else
                 
                  @click.native.prevent="update">更新
      </el-button>
      </div>
    </el-dialog>



    </div>
</template>

<script>
import  { list, addUser ,updateUser ,remove } from "@/api/user";
export default {
  
    data() {
      return{
       dialogFormVisible: false,
       listLoading: false, // 数据加载等待动画
       dialogStatus: 'add',//默认add
        textMap: {
        update: '更新用户',
        add: '添加用户'
        },
       form: {
          id: "",
          username: '',
          password:'',
          email:'', 
          address:'',
          tel:''
        },
        formLabelWidth: '120px'
     };
    },

    methods: {
         add(){
      // let data=this.form
      // console.log(data)、
      this.dialogStatus = 'add'
      // btnLoading: true
      let data={
        username:this.form.username,
        password:this.form.password,
        email:this.form.email,
        address:this.form.address
      }
      this.readonly = false
      console.log(data)

      addUser(data).then(()=>{
          this.$message.success('add success')
          this.dialogFormVisible = false
          this.listLoading = true
          location.reload() ;
          this.getUserListA();
          console.log(data)
        })
     
     // this.getUserListA()
    },

        update(){
        updateUser(this.form).then(()=>{
        this.$message.success('edit success')
        this.dialogFormVisible = false
        this.listLoading = true
        this.getUserListA()
        
        console.log(this.form,'==============')
      })

    },
 
    },
    props:['Data']
}
</script>

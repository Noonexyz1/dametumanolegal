import { Tooltip } from "@material-tailwind/react"
import { Area, AreaChart, CartesianGrid, ResponsiveContainer, XAxis, YAxis } from "recharts"

const data = [
    { name: "María", age: 10, weight: 60 },
    { name: 'Karina', age: 25, weight: 70 },
    { name: 'Susana', age: 15, weight: 65 },
    { name: 'Pedro', age: 35, weight: 85 },
    { name: 'Felipe', age: 12, weight: 48 },
    { name: 'Laura', age: 30, weight: 69 },
    { name: 'Adrián', age: 15, weight: 78 },
]

export default function AreaChartGraf() {
    return (
        <div>
            <h3 className='text-2xl text-white pt-4 pl-2'>Bienvenido Dr. Chapatin</h3>

            <div className="sm:mx-auto flex flex-row justify-start border border-white rounded-2xl h-72 my-2 mx-2 pt-16 sm:pt-0">
                <ResponsiveContainer width="100%" aspect={2}>
                    <AreaChart
                        width={500}
                        height={400}
                        data={data}
                        margin={{
                            top: 10,
                            right: 30,
                            left: 0,
                            bottom: 0
                        }}
                    >
                        <CartesianGrid strokeDasharray="3 3" />
                        <XAxis dataKey="name" />
                        <YAxis />
                        <Tooltip />
                        <Area type="monotone" dataKey="age" stackId="1" stroke='#8884d8' fill="#8884d8" />
                        <Area type="monotone" dataKey="weight" stackId="1" stroke='#82caed' fill="#fad3cf" />
                    </AreaChart>
                </ResponsiveContainer>
            </div>
        </div>

    )
}
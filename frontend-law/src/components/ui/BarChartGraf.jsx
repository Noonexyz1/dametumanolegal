import { Tooltip } from "@material-tailwind/react"
import { Bar, BarChart, CartesianGrid, Legend, ResponsiveContainer, XAxis, YAxis } from "recharts"

const data = [
    { name: "María", age: 10, weight: 60 },
    { name: 'Karina', age: 25, weight: 70 },
    { name: 'Susana', age: 15, weight: 65 },
    { name: 'Pedro', age: 35, weight: 85 },
    { name: 'Felipe', age: 12, weight: 48 },
    { name: 'Laura', age: 30, weight: 69 },
    { name: 'Adrián', age: 15, weight: 78 },
]

export default function BarChartGraf() {
    return (
        <div>
            <h3 className='text-2xl text-white pt-4 pl-2'>Bienvenido Dr. Chapatin</h3>

            <div className="sm:mx-auto flex flex-row justify-start border border-white rounded-2xl h-72 my-2 mx-2 pt-16 sm:pt-0">
                <ResponsiveContainer width="100%" aspect={2}>
                    <BarChart
                        data={data}
                        width={500}
                        height={400}
                        margin={{
                            top: 10,
                            right: 30,
                            left: 0,
                            bottom: 0
                        }}
                    >
                        <CartesianGrid strokeDasharray="4 1 2" />
                        <XAxis dataKey="name" />
                        <YAxis />
                        <Tooltip />
                        <Legend />
                        <Bar dataKey="weight" fill="#6b48ff" />
                        <Bar dataKey="age" fill="#1ee3cf" />
                    </BarChart>
                </ResponsiveContainer>
            </div>
        </div>

    )
}